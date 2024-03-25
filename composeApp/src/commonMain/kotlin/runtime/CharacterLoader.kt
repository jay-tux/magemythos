package runtime

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.encodeToStream
import runtime.DfsRuntime.Companion.CharacterOrHelpers.Companion.prepare
import runtime.ast.JsonExt.requireArray
import runtime.ast.JsonExt.requireInt
import runtime.ast.JsonExt.requireKey
import runtime.ast.JsonExt.requireObject
import runtime.ast.JsonExt.requirePrimitive
import runtime.ast.JsonExt.requireString
import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.RTType
import runtime.ast.RTType.Companion.toRTT
import runtime.ast.Value
import runtime.ast.ValueSerialization.toJson
import runtime.ast.ValueSerialization.toValue

@OptIn(ExperimentalSerializationApi::class)
object CharacterLoader {
    class CharacterParsingError(message: String) : Exception(message)

    private const val NAME_KEY = "name"
    private const val RACE_KEY = "race"
    private const val SUBRACE_KEY = "subrace"
    private const val CLASS_KEY = "class"
    private const val CLASS_RTT_KEY = "rtt"
    private const val CLASS_LEVEL_KEY = "lvl"
    private const val BACKGROUND_KEY = "background"
    private const val CHOICES_KEY = "choices"

    private suspend fun parse(content: JsonElement): Character {
        val root = content.requireObject()
        val name = root.requireKey(NAME_KEY).requirePrimitive().requireString()
        val race = Json.decodeFromJsonElement<RTType>(root.requireKey(RACE_KEY))
        val raceObj = race.ctor<Race>("race")
        val subrace = root[SUBRACE_KEY]?.let { Json.decodeFromJsonElement<RTType>(it) }
        val subraceObj = subrace?.ctor<Subrace>("subrace")
        val clazz = root.requireKey(CLASS_KEY).requireArray().map { c ->
            val obj = c.requireObject()
            val cls = Json.decodeFromJsonElement<RTType>(obj.requireKey(CLASS_RTT_KEY))
            val level = obj.requireKey(CLASS_LEVEL_KEY).requirePrimitive().requireInt()
            Character.CharacterClass(cls.ctor<Class>("class"), level)
        }
        val background = Json.decodeFromJsonElement<RTType>(root.requireKey(BACKGROUND_KEY))
        val backgroundObj = background.ctor<Background>("background")

        val choices = root.requireKey(CHOICES_KEY).requireObject()
        val choiceMap = mutableMapOf<String, Value>()
        choices.forEach { (k, v) ->
            val obj = v.requireObject()
            choiceMap[k] = obj.toValue()
        }

        val c = Character(name, raceObj, subraceObj, clazz, backgroundObj, choiceMap)
        Library.character = c
        Library.choice = object : ChoiceScope {
                override fun getChoice(name: String): Value? = choiceMap[name]
                override operator fun invoke(what: ChoiceDesc) = throw ArbitraryRuntimeError("Can't invoke choices while in character loading!")
                override fun choiceMade(name: String, result: Value) {}
        }

        val pos = Pos("<runtime>", "ldChar", 0, 0)
        Runtime.getLogger().logMessage("[LD_CHAR]: Restoring character race (${raceObj.name})...")
        DfsRuntime.ready(ObjectValue(raceObj, mapOf(), pos), "onSelect", listOf(), pos, c.prepare())
        DfsRuntime.getInstance().run()
        if(subraceObj != null) {
            Runtime.getLogger().logMessage("[LD_CHAR]: Restoring character sub-race (${subraceObj.name})...")
            DfsRuntime.ready(ObjectValue(subraceObj, mapOf(), pos), "onSelect", listOf(), pos, c.prepare())
            DfsRuntime.getInstance().run()
        }
        clazz.forEach { cl ->
            Runtime.getLogger().logMessage("[LD_CHAR]: Restoring character class (${cl.clazz.name})...")
            DfsRuntime.ready(ObjectValue(cl.clazz, mapOf(), pos), "onSelect", listOf(), pos, c.prepare())
            DfsRuntime.getInstance().run()
            // TODO: for each level, also call level up
        }
        Runtime.getLogger().logMessage("[LD_CHAR]: Restoring character background (${backgroundObj.name})...")
        DfsRuntime.ready(ObjectValue(backgroundObj, mapOf(), pos), "onSelect", listOf(), pos, c.prepare())
        DfsRuntime.getInstance().run()
        return c
    }

    suspend fun load(loader: ILoader) {
        val list = loader.loadCharacterList()
        val all = Json.decodeFromStream<List<String>>(list)
        all.forEach { name ->
            try {
                Runtime.getLogger().logMessage("[LD_CHAR]: Loading character $name...")
                val stream = loader.loadCharacter(name)
                val tree = Json.parseToJsonElement(stream.reader().readText())
                Runtime.getCache().register(parse(tree))
            }
            catch(e: Exception) {
                Runtime.getLogger().logError("[LD_CHAR]: Failed to load character $name: ${e.message}")
            }
        }
    }

    private suspend fun save(c: Character): JsonElement {
        return JsonObject(mapOf(
            NAME_KEY to JsonPrimitive(c.name.value),
            RACE_KEY to Json.encodeToJsonElement(c.race.value.toRTT()),
            SUBRACE_KEY to Json.encodeToJsonElement(c.subrace.value?.toRTT()),
            CLASS_KEY to JsonArray(c.clazz.value.map { cls ->
                JsonObject(mapOf(
                    CLASS_RTT_KEY to Json.encodeToJsonElement(cls.clazz.toRTT()),
                    CLASS_LEVEL_KEY to JsonPrimitive(cls.level)
                ))
            }),
            BACKGROUND_KEY to Json.encodeToJsonElement(c.background.value.toRTT()),
            CHOICES_KEY to JsonObject(c.choices.mapValues { (_, v) -> v.toJson() })
        ))
    }

    suspend fun storeOne(storage: IStorage, char: Character): Boolean {
        return try {
            val name = char.name.value
            Runtime.getLogger().logMessage("[ST_CHAR]: Saving character $name...")
            val stream = storage.saveCharacter(name)
            stream.writer().use { writer ->
                val json = save(char)
                writer.append(json.toString())
            }
            true
        } catch(e: Exception) {
            Runtime.getLogger().logError("[ST_CHAR]: Failed to store character ${char.name.value}: ${e.message}")
            false
        }
    }

    suspend fun store(storage: IStorage) {
        val all = Runtime.getCache().characterIterator()
        val succeeded = mutableListOf<String>()
        all.forEach {
            if(storeOne(storage, it)) succeeded.add(it.name.value)
        }

        val list = storage.saveCharacterList()
        Json.encodeToStream(succeeded, list)
    }
}