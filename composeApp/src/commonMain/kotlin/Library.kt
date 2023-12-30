import parser.ast.*
import java.io.File
import java.io.FileNotFoundException

class DuplicateDefinitionException(name: String, pos: Pos, ogPos: Pos) :
    Exception("Duplicate definition of $name at $pos (previous definition at $ogPos)")

class Library private constructor(
    val classes: Map<String, ClassDeclaration>, val races: Map<String, RaceDeclaration>,
    val subClasses: Map<String, SubClassDeclaration>, val subRaces: Map<String, SubRaceDeclaration>,
    val items: Map<String, ItemDeclaration>, val spells: Map<String, SpellDeclaration>,
    val backgrounds: Map<String, BackgroundDeclaration>, val abilities: Map<String, AbilityDeclaration>,
    val skills: Map<String, SkillDeclaration>, val resolved: List<String>, val sources: List<String>
) {
    class Builder() {
        val classes = mutableMapOf<String, ClassDeclaration>()
        val races = mutableMapOf<String, RaceDeclaration>()
        val subClasses = mutableMapOf<String, SubClassDeclaration>()
        val subRaces = mutableMapOf<String, SubRaceDeclaration>()
        val items = mutableMapOf<String, ItemDeclaration>()
        val spells = mutableMapOf<String, SpellDeclaration>()
        val backgrounds = mutableMapOf<String, BackgroundDeclaration>()
        val abilities = mutableMapOf<String, AbilityDeclaration>()
        val skills = mutableMapOf<String, SkillDeclaration>()
        val resolved = mutableListOf<String>()
        val sources = mutableListOf<String>()

        constructor(lib: Library) : this() {
            classes += lib.classes
            races += lib.races
            subClasses += lib.subClasses
            subRaces += lib.subRaces
            items += lib.items
            spells += lib.spells
            backgrounds += lib.backgrounds
            abilities += lib.abilities
            skills += lib.skills
            resolved += lib.resolved
            sources += lib.sources
        }

        fun tlGet(k: String): AstNode? = classes[k] ?: races[k] ?: subClasses[k] ?: subRaces[k] ?:
            items[k] ?: spells[k] ?: backgrounds[k] ?: abilities[k] ?: skills[k]

        fun build() = Library(classes, races, subClasses, subRaces, items, spells, backgrounds, abilities, skills, resolved, sources)
    }

    private constructor() : this(mapOf(), mapOf(), mapOf(), mapOf(), mapOf(), mapOf(),
        mapOf(), mapOf(), mapOf(), listOf(), listOf())

    operator fun plus(file: String) = loadInto(file, this)

    fun verify() {
        subClasses.forEach {
            if(!classes.containsKey(it.value.subFor)) {
                throw Exception("Sub-class ${it.key} is for non-existent class ${it.value.subFor}")
            }
        }

        subRaces.forEach {
            if(!races.containsKey(it.value.subFor)) {
                throw Exception("Sub-class ${it.key} is for non-existent race ${it.value.subFor}")
            }
        }

        skills.forEach {
            if(!abilities.containsKey(it.value.dependsOn)) {
                throw Exception("Skill ${it.key} uses non-existent ability ${it.value.dependsOn}")
            }
        }
    }

    companion object {
        private fun <V: AstNode> avoidDuplicates(src: Builder, target: MutableMap<String, V>, insert: List<V>, extract: (V) -> String) {
            insert.forEach {
                val k = extract(it)
                src.tlGet(k)?.let { prev ->
                    throw DuplicateDefinitionException(k, prev.pos, it.pos)
                } ?: run {
                    target[k] = it
                }
            }
        }

        fun loadInto(file: String, target: Library): Library {
            val canonical = File(file).canonicalPath
            if(target.resolved.contains(canonical)) {
                return target
            }

            val builder = Builder(target)
            val unresolved = ArrayDeque<String>()
            unresolved.add(canonical)

            while(unresolved.isNotEmpty()) {
                val next = unresolved.removeFirst()
                println(" -> Attempting to load $next")
                val set = DataLoader.loadFrom(next)
                builder.resolved.add(next)

                set.tree.deps.forEach {
                    val canonicalDep = DataLoader.attemptResolve(it, next)
                        ?: throw FileNotFoundException("   -> Unable to resolve dependency $it from $next")
                    if(!builder.resolved.contains(canonicalDep)) {
                        unresolved.add(canonicalDep)
                    }
                }

                avoidDuplicates(builder, builder.classes, set.tree.classes) { it.name }
                avoidDuplicates(builder, builder.races, set.tree.races) { it.name }
                avoidDuplicates(builder, builder.subClasses, set.tree.subClasses) { it.name }
                avoidDuplicates(builder, builder.subRaces, set.tree.subRaces) { it.name }
                avoidDuplicates(builder, builder.items, set.tree.items) { it.name }
                avoidDuplicates(builder, builder.spells, set.tree.spells) { it.name }
                avoidDuplicates(builder, builder.backgrounds, set.tree.backgrounds) { it.name }
                avoidDuplicates(builder, builder.abilities, set.tree.abilities) { it.name }
                avoidDuplicates(builder, builder.skills, set.tree.skills) { it.name }

                if(!builder.sources.contains(set.tree.source)) {
                    builder.sources.add(set.tree.source)
                }
            }

            return builder.build()
        }

        fun empty() = Library()
    }
}
