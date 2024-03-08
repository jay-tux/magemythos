package runtime

import ILogger
import immutable
import org.apache.commons.lang3.StringUtils
import runtime.ast.ArbitraryAstError
import runtime.ast.Currency
import runtime.ast.CurrencyValue
import runtime.ast.DiceValue
import runtime.ast.Expression
import runtime.ast.FunDeclaration
import runtime.ast.IntValue
import runtime.ast.InvalidKindError
import runtime.ast.InvalidObjectTypeError
import runtime.ast.ListValue
import runtime.ast.MemberDeclaration
import runtime.ast.MissingDescriptionError
import runtime.ast.MissingTagError
import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.RollValue
import runtime.ast.Statement
import runtime.ast.Tag
import runtime.ast.TagEffect
import runtime.ast.TypeDeclaration
import runtime.ast.Value
import runtime.ast.Variable

sealed class Type(val name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, val pos: Pos) {
    protected val fieldsIntl = fields.toMutableList()
    val fields = fieldsIntl.immutable()

    private var _tags: List<Tag> = listOf()
    private lateinit var _cache: ICache

    private enum class State { WAITING, FINALIZING, READY }
    private var state = State.WAITING

    protected val membersIntl = members.toMutableList()
    val members = membersIntl.immutable()


    var displayName: String = name
        protected set

    lateinit var description: String
        protected set

    protected abstract fun mkScope(): TagScope

    open fun verify() {
        if(!::description.isInitialized) throw MissingDescriptionError(mkScope().kind(), name, pos)
    }

    fun construct(at: Pos): ObjectValue {
        if(fields.isNotEmpty()) throw ArbitraryRuntimeError("Unable to construct values of type $name: member fields are unsupported (at $at)")
        return ObjectValue(this, mutableMapOf(), at)
    }

    private fun mkVariable(it: Pair<MemberDeclaration, Value>) = it.first.name to Variable(it.first.name, it.second, true, it.second.pos)

    interface TagScope {
        fun changeName(newName: String)
        fun hasDesc(): Boolean
        fun changeDesc(newDesc: String)
        fun addMember(member: FunDeclaration)
        fun addField(field: MemberDeclaration)
        fun kind(): String
        fun appendOrCreateMember(name: String, stmts: List<Statement>, argNames: List<String> = listOf())
        fun getFunNthArgument(fn: String, n: Int): String?
    }

    protected abstract inner class TagScopeImpl : TagScope {
        override fun changeName(newName: String) {
            displayName = newName
        }

        override fun changeDesc(newDesc: String) {
            description = newDesc
        }

        override fun addMember(member: FunDeclaration) {
            membersIntl.add(member)
        }

        override fun addField(field: MemberDeclaration) {
            fieldsIntl.add(field)
        }

        override fun appendOrCreateMember(name: String, stmts: List<Statement>, argNames: List<String>) {
            membersIntl.find { it.name == name }?.growBody(stmts)
                ?: addMember(FunDeclaration(name, argNames, stmts, pos))
        }

        override fun getFunNthArgument(fn: String, n: Int): String? =
            membersIntl.find { it.name == name }?.params?.getOrNull(n)

        override fun hasDesc(): Boolean = this@Type::description.isInitialized
    }

    suspend fun finalize() {
        if(state == State.WAITING) {
            state = State.FINALIZING
            val scope = mkScope()
            _tags.forEach { TagEffect.applyTag(scope, it.name, it.arguments, it.pos) }
            _tags = listOf()
            state = State.READY
            verify()
        }
        else if(state == State.FINALIZING) {
            throw ArbitraryAstError("Type $name (declared at $pos) is part of a dependency cycle.")
        }
    }

    companion object {
        fun TypeDeclaration.build(): Type {
            return when(kind) {
                "ability" -> Ability(name, fields, members, pos)
                "skill" -> Skill(name, fields, members, pos)
                "size" -> Size(name, fields, members, pos)
                "language" -> Language(name, fields, members, pos)
                "damage" -> Damage(name, fields, members, pos)
                "feat" -> Feat(name, fields, members, pos)
                "trait" -> Trait(name, fields, members, pos)
                "race" -> Race(name, fields, members, pos)
                "subrace" -> Subrace(name, fields, members, pos)
                "class" -> Class(name, fields, members, pos)
                "subclass" -> Subclass(name, fields, members, pos)
                "itemkind" -> ItemKind(name, fields, members, pos)
                "itemtag" -> ItemTag(name, fields, members, pos)
                "item" -> Item(name, fields, members, pos)
                "spell" -> Spell(name, fields, members, pos)
                "spellschool" -> Spellschool(name, fields, members, pos)
                "background" -> Background(name, fields, members, pos)
                else -> throw InvalidKindError(name, kind, pos)
            }.also {
                if(hasDescription()) it.description = this.description
                it.displayName = StringUtils.splitByCharacterTypeCamelCase(it.name).joinToString(" ")
                it._tags = tags
                it._cache = Runtime.getCache()
            }
        }
    }
}

class Ability(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    override fun mkScope(): TagScope = object : TagScopeImpl() { override fun kind(): String = "Ability" }
}

class Skill(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    lateinit var ability: Ability
        private set

    interface SkillTagScope : TagScope {
        fun changeAbility(newAbility: ObjectValue)
    }

    private inner class SkillTagScopeImpl : TagScopeImpl(), SkillTagScope {
        override fun kind(): String = "Skill"

        override fun changeAbility(newAbility: ObjectValue) {
            ability = newAbility.type as? Ability ?: throw InvalidObjectTypeError("Ability", newAbility.type.javaClass.simpleName, newAbility.pos)
        }
    }

    override fun mkScope(): TagScope = SkillTagScopeImpl()

    override fun verify() {
        super.verify()
        if (!::ability.isInitialized) throw MissingTagError(name, "Skill", "ability", "@ability", pos)
    }
}

class Size(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    override fun mkScope(): TagScope = object : TagScopeImpl() { override fun kind(): String = "Size" }
}

class Language(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    override fun mkScope(): TagScope = object : TagScopeImpl() { override fun kind(): String = "Language" }
}

class Damage(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    override fun mkScope(): TagScope = object : TagScopeImpl() { override fun kind(): String = "Damage" }
}

class Feat(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    override fun mkScope(): TagScope = object : TagScopeImpl() { override fun kind(): String = "Feat" }
}

class Trait(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    var repeatable: Boolean = false
        private set

    interface TraitTagScope : TagScope {
        fun makeRepeatable()
    }

    private inner class TraitTagScopeImpl : TagScopeImpl(), TraitTagScope {
        override fun kind(): String = "Trait"

        override fun makeRepeatable() {
            repeatable = true
        }
    }

    override fun mkScope(): TagScope = TraitTagScopeImpl()
}

class Race(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    var hasSubraces: Boolean = false
        private set

    lateinit var size: Size
        private set

    interface RaceTagScope : TagScope {
        fun enableSubrace()
        fun setSize(size: ObjectValue)
    }

    private inner class RaceTagScopeImpl : TagScopeImpl(), RaceTagScope {
        override fun kind(): String = "Race"

        override fun enableSubrace() {
            hasSubraces = true
        }

        override fun setSize(size: ObjectValue) {
            this@Race.size = size.type as? Size ?: throw InvalidObjectTypeError("Size", size.type.javaClass.simpleName, size.pos)
        }
    }

    override fun mkScope(): TagScope = RaceTagScopeImpl()

    override fun verify() {
        super.verify()
        if (!::size.isInitialized) throw MissingTagError(name, "Race", "size", "@size", pos)
    }
}

class Subrace(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    lateinit var baseRace: Race
        private set

    interface SubraceTagScope : TagScope {
        fun setBaseRace(baseRace: ObjectValue)
    }

    private inner class SubraceTagScopeImpl : TagScopeImpl(), SubraceTagScope {
        override fun kind(): String = "Subrace"

        override fun setBaseRace(baseRace: ObjectValue) {
            this@Subrace.baseRace = baseRace.type as? Race ?: throw InvalidObjectTypeError("Race", baseRace.type.javaClass.simpleName, baseRace.pos)
        }
    }

    override fun mkScope(): TagScope = SubraceTagScopeImpl()

    override fun verify() {
        super.verify()
        if (!::baseRace.isInitialized) throw MissingTagError(name, "Subrace", "base race", "@baseRace", pos)
        if(!baseRace.hasSubraces) throw ArbitraryAstError("For subrace $name (declared at $pos): base race ${baseRace.name} does not support subraces.")
    }
}

class Background(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    interface BackgroundTagScope : TagScope
    private inner class BackgroundTagScopeImpl : TagScopeImpl(), BackgroundTagScope {
        override fun kind(): String = "Background"
    }

    override fun mkScope(): TagScope = BackgroundTagScopeImpl()
}

sealed class SpellcasterKind(val ab: Ability, val slotsByLevel: List<List<Int>>, val spellList: List<Spell>, val cantripsByLevel: List<Int>) {
    class KnownCaster(ab: Ability, slotsByLevel: List<List<Int>>, spellList: List<Spell>, cantripsByLevel: List<Int>, val knownByLevel: List<Int>) : SpellcasterKind(ab, slotsByLevel, spellList, cantripsByLevel)

    // TODO: rest of kinds
}

class Class(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    lateinit var hitDie: DiceValue
        private set

    var spellcaster: SpellcasterKind? = null
        private set

    var ritualCasting: Boolean = false
        private set

    interface ClassTagScope : TagScope {
        fun setHitDie(hitDie: DiceValue)
        fun setCaster(caster: SpellcasterKind)
        fun enableRitualCasting()
    }

    private inner class ClassTagScopeImpl : TagScopeImpl(), ClassTagScope {
        override fun kind(): String = "Class"

        override fun setHitDie(hitDie: DiceValue) {
            this@Class.hitDie = hitDie
        }

        override fun setCaster(caster: SpellcasterKind) {
            spellcaster = caster
        }

        override fun enableRitualCasting() {
            ritualCasting = true
        }
    }

    override fun mkScope(): TagScope = ClassTagScopeImpl()

    override fun verify() {
        super.verify()
        if(!::hitDie.isInitialized) throw MissingTagError(name, "Class", "hit die", "@hitDie", pos)
    }
}

sealed class TraitOrList {
    class TraitValue(val trait: Trait) : TraitOrList()
    class ListValue(val list: List<TraitOrList>) : TraitOrList()

    fun toTraitList(): List<Trait> = when(this) {
        is TraitValue -> listOf(trait)
        is ListValue -> list.flatMap { it.toTraitList() }
    }

    companion object {
        fun fromValue(v: Value): TraitOrList = when(v) {
            is ObjectValue -> TraitValue(v.type as? Trait ?: throw InvalidObjectTypeError("Trait", v.type.javaClass.simpleName, v.pos))
            is runtime.ast.ListValue -> ListValue(v.value.map { fromValue(it) })
            else -> throw InvalidObjectTypeError("Trait or List", v.javaClass.simpleName, v.pos)
        }
    }
}

class Subclass(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    lateinit var baseClass: Class
        private set

    lateinit var traits: List<TraitOrList>
        private set

    interface SubclassTagScope : TagScope {
        fun setBaseClass(baseClass: ObjectValue)
        fun setTraits(traits: ListValue)
    }

    private inner class SubclassTagScopeImpl : TagScopeImpl(), SubclassTagScope {
        override fun kind(): String = "Subclass"

        override fun setBaseClass(baseClass: ObjectValue) {
            this@Subclass.baseClass = baseClass.type as? Class ?: throw InvalidObjectTypeError("Class", baseClass.type.javaClass.simpleName, baseClass.pos)
        }

        override fun setTraits(traits: ListValue) {
            this@Subclass.traits = traits.value.map { TraitOrList.fromValue(it) }
        }
    }

    override fun mkScope(): TagScope = SubclassTagScopeImpl()

    override fun verify() {
        super.verify()
        if (!::baseClass.isInitialized) throw MissingTagError(name, "Subclass", "base class", "@baseClass", pos)
        if(!::traits.isInitialized) throw MissingTagError(name, "Subclass", "traits", "@traits", pos)
    }
}

class ItemKind(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    override fun mkScope(): TagScope = object : TagScopeImpl() { override fun kind(): String = "ItemKind" }
}

class ItemTag(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    var kind: ItemKind? = null
        private set

    interface ItemTagScope : TagScope {
        fun setKind(kind: ObjectValue)
    }

    private inner class ItemTagScopeImpl : TagScopeImpl(), ItemTagScope {
        override fun kind(): String = "ItemTag"

        override fun setKind(kind: ObjectValue) {
            this@ItemTag.kind = kind.type as? ItemKind ?: throw InvalidObjectTypeError("ItemKind", kind.type.javaClass.simpleName, kind.pos)
        }
    }

    override fun mkScope(): TagScope = ItemTagScopeImpl()
}

sealed class ItemData

class Armor(val baseAc: Int, val maxDex: Int, val minStr: Int, val stealthDisadv: Boolean) : ItemData()

sealed class IntOrRoll {
    class IORInt(val value: IntValue) : IntOrRoll()
    class IORRoll(val value: RollValue) : IntOrRoll()

    companion object {
        fun int(v: IntValue) = IORInt(v)
        fun roll(v: RollValue) = IORRoll(v)

        fun IntValue.toIOR() = IORInt(this)
        fun RollValue.toIOR() = IORRoll(this)
    }
}

class Weapon(val kindTag: ItemTag, val rangeTag: ItemTag, val damage: IntOrRoll, val damageType: Damage) : ItemData()

class Pack(included: List<ObjectValue>) : ItemData() {
    val included = included.map {
        it.type as? Item ?: throw InvalidObjectTypeError("Item", it.type.javaClass.simpleName, it.pos)
    }
}

data object Tool : ItemData()

class Item(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    var cost: CurrencyValue = CurrencyValue(-1, Currency.CP, pos)
        private set

    var weight: Float = -1f
        private set

    var getAtOnce: Int = 1
        private set

    private val _tags = mutableListOf<ItemTag>()
    val tags = _tags.immutable()

    private val _data = mutableListOf<ItemData>()
    val data = _data.immutable()

    interface ItemScope : TagScope {
        fun setCost(cost: CurrencyValue)
        fun setWeight(weight: Float)
        fun setPer(per: Int)
        fun addTag(tag: ObjectValue)
        fun addData(data: ItemData)
        fun tags(): List<ItemTag>
    }

    private inner class ItemScopeImpl : TagScopeImpl(), ItemScope {
        override fun kind(): String = "Item"

        override fun setCost(cost: CurrencyValue) {
            this@Item.cost = cost
        }

        override fun setWeight(weight: Float) {
            this@Item.weight = weight
        }

        override fun addTag(tag: ObjectValue) {
            _tags.add(tag.type as? ItemTag ?: throw InvalidObjectTypeError("ItemTag", tag.type.javaClass.simpleName, tag.pos))
        }

        override fun addData(data: ItemData) {
            _data.add(data)
        }

        override fun setPer(per: Int) {
            getAtOnce = per
        }

        override fun tags(): List<ItemTag> = tags
    }

    override fun mkScope(): TagScope = ItemScopeImpl()

    override fun verify() {
        super.verify()
        if(cost.amount < 0) throw MissingTagError(name, "Item", "cost", "@value", pos)
        if(weight == -1f) throw MissingTagError(name, "Item", "weight", "@weight", pos)
    }
}

class Spellschool(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    override fun mkScope(): TagScope = object : TagScopeImpl() { override fun kind(): String = "Spellschool" }
}

sealed class SpellDuration
data object Instantaneous : SpellDuration()
class Concentration(val upTo: String) : SpellDuration()
class NoConcentration(val duration: String) : SpellDuration()

class Spell(name: String, fields: List<MemberDeclaration>, members: List<FunDeclaration>, pos: Pos) : Type(name, fields, members, pos) {
    lateinit var school: Spellschool
        private set
    lateinit var duration: SpellDuration
        private set

    interface SpellTagScope : TagScope {
        fun setSchool(school: ObjectValue)
        fun setDuration(duration: SpellDuration)
    }

    private inner class SpellTagScopeImpl : TagScopeImpl(), SpellTagScope {
        override fun kind(): String = "Spell"

        override fun setSchool(school: ObjectValue) {
            this@Spell.school = school.type as? Spellschool ?: throw InvalidObjectTypeError("Spellschool", school.type.javaClass.simpleName, school.pos)
        }

        override fun setDuration(duration: SpellDuration) {
            this@Spell.duration = duration
        }
    }

    override fun mkScope(): TagScope = SpellTagScopeImpl()

    override fun verify() {
        super.verify()
        if (!::school.isInitialized) throw MissingTagError(name, "Spell", "school", "@school", pos)
    }
}