package runtime

import androidx.compose.runtime.mutableStateOf
import immutable
import runtime.DfsRuntime.Companion.CharacterOrHelpers.Companion.prepare
import runtime.ast.AssignmentStmt
import runtime.ast.BinaryExpression
import runtime.ast.BreakStmt
import runtime.ast.CallExpression
import runtime.ast.ExprStmt
import runtime.ast.Expression
import runtime.ast.ForStmt
import runtime.ast.FunDeclaration
import runtime.ast.IfStmt
import runtime.ast.IndexExpression
import runtime.ast.ListExpression
import runtime.ast.LiteralExpression
import runtime.ast.MappedIntExpression
import runtime.ast.MemberCallExpression
import runtime.ast.MemberExpression
import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.RangeExpression
import runtime.ast.ReturnStmt
import runtime.ast.Statement
import runtime.ast.TernaryExpression
import runtime.ast.UnaryExpression
import runtime.ast.Value
import runtime.ast.VariableExpression
import runtime.ast.WhileStmt
import java.util.EnumSet

class Character(
    name: String,
    race: Race, subrace: Subrace?, clazz: List<CharacterClass>, background: Background,
    choices: Map<String, Value> = mapOf(), hp: Pair<Int, Int> = 0 to 0
) {
    enum class CharacterFlag { DISABLE_SPELLS }
    class CharacterFlags(private val flags: EnumSet<CharacterFlag> = EnumSet.noneOf(CharacterFlag::class.java)) {
        infix fun and(other: CharacterFlag) = CharacterFlags(EnumSet.copyOf(flags).also { it.add(other) })
        infix fun not(other: CharacterFlag) = CharacterFlags(EnumSet.copyOf(flags).also { it.remove(other) })
        infix fun has(other: CharacterFlag) = flags.contains(other)
    }
    data class CharacterClass(val clazz: Class, val level: Int)
    data class ItemDetails(val item: Item, val amount: Int, val equipped: Boolean)

    val choices: MutableMap<String, Value> = choices.toMutableMap()

    private val _name = mutableStateOf(name)
    val name = _name.immutable()

    private val _race = mutableStateOf(race)
    val race = _race.immutable()

    private val _subrace = mutableStateOf(subrace)
    val subrace = _subrace.immutable()

    private val _class = mutableStateOf(clazz)
    val clazz = _class.immutable()

    private val _background = mutableStateOf(background)
    val background = _background.immutable()

    private val _hp = mutableStateOf(Pair(0, 0))
    val hp = _hp.immutable()

    private val _abilities = mutableStateOf(Runtime.getCache().typesOfKind<Ability>().associateWith { 0 })
    val abilities = _abilities.immutable()

    private val _saves = mutableStateOf(listOf<Ability>())
    val saves = _saves.immutable()

    private val _inventory = mutableStateOf(listOf<ItemDetails>())
    val inventory = _inventory.immutable()

    private val _traits = mutableStateOf(listOf<Trait>())
    val traits = _traits.immutable()

    private val _languages = mutableStateOf(listOf<Language>())
    val languages = _languages.immutable()

    private val _proficiencies = mutableStateOf(listOf<Skill>())
    val proficiencies = _proficiencies.immutable()

    private val _skillBonuses = mutableStateOf(mapOf<Skill, Int>())
    val skillBonuses = _skillBonuses.immutable()

    private val _flags = mutableStateOf(CharacterFlags())
    val flags = _flags.immutable()

    private val _vulnerabilities = mutableStateOf(listOf<Damage>())
    val vulnerabilities = _vulnerabilities.immutable()

    private val _resistances = mutableStateOf(listOf<Damage>())
    val resistances = _resistances.immutable()

    private val _immunities = mutableStateOf(listOf<Damage>())
    val immunities = _immunities.immutable()

    private val _baseAC = mutableStateOf(10)
    val baseAc = _baseAC.immutable()

    private val _modAC = mutableStateOf(0)
    val modAC = _modAC.immutable()

    private val _speed = mutableStateOf(30)
    val speed = _speed.immutable()

    private val _spells = mutableStateOf(listOf<Pair<Spell, Ability?>>())
    val spells = _spells.immutable()

    private val _itemTypeProfs = mutableStateOf(listOf<ItemTag>())
    val itemTypeProfs = _itemTypeProfs.immutable()

    private val _itemProfs = mutableStateOf(listOf<Item>())
    val itemProfs = _itemProfs.immutable()

    fun registerChoice(name: String, result: Value) {
        choices[name] = result
    }
    fun retrieveChoice(name: String): Value? = choices[name]

    fun setFlag(flag: CharacterFlag, value: Boolean) {
        _flags.value = _flags.value and flag
    }

    fun unsetFlag(flag: CharacterFlag) {
        _flags.value = _flags.value not flag
    }

    fun setAC(base: Int = _baseAC.value, mod: Int = _modAC.value) {
        _baseAC.value = base
        _modAC.value = mod
    }

    fun updSpeed(newSpeed: Int) {
        _speed.value = newSpeed
    }

    fun setAbility(ability: Ability, value: Int) {
        _abilities.value = _abilities.value.toMutableMap().also { it[ability] = value }
    }

    fun addSkillProf(skill: Skill) {
        _proficiencies.value += skill
    }

    fun addSkillBonus(skill: Skill, value: Int) {
        val old = _skillBonuses.value
        _skillBonuses.value = old.toMutableMap().also { it[skill] = (old[skill] ?: 0) + value }
    }

    fun addSpell(spell: Spell, ability: Ability? = null) {
        _spells.value += spell to ability
    }

    fun addResistance(damage: Damage) {
        _resistances.value += damage
    }

    fun addItemProf(item: ItemTag) {
        _itemTypeProfs.value += item
    }

    fun addItemProf(item: Item) {
        _itemProfs.value += item
    }

    fun addMaxHp(value: Int) {
        val (old, max) = _hp.value
        _hp.value = old to max + value
    }

    fun addCurrentHp(value: Int) {
        val (old, max) = _hp.value
        _hp.value = (old + value).coerceAtMost(max) to max
    }

    fun dealDamage(value: Int) {
        val (old, max) = _hp.value
        _hp.value = old - value to max
    }

    fun addLanguage(l: Language) {
        _languages.value += l
    }

    fun addTrait(t: Trait) {
        _traits.value += t
    }

    fun addSaveProf(ability: Ability) {
        _saves.value += ability
    }

    fun addItem(item: Item, count: Int) {
        val old = _inventory.value
        val index = old.indexOfFirst { it.item == item }
        if(index == -1) _inventory.value = old + ItemDetails(item, count, false)
        else {
            val temp = old.toMutableList()
            temp[index] = temp[index].copy(amount = temp[index].amount + count)
            _inventory.value = temp
        }
    }

    inner class Builder {
        val result = this@Character
        private val choices = mutableMapOf<String, Value>()
        private var state = 0

        private fun selector(): ObjectValue = when(state) {
            0 -> ObjectValue(race.value, mapOf(), runtimePos)
            1 -> {
                val temp = subrace.value
                if(temp != null) ObjectValue(temp, mapOf(), runtimePos)
                else {
                    state++
                    selector()
                }
            }
            2 -> ObjectValue(clazz.value[0].clazz, mapOf(), runtimePos)
            3 -> {
                dumpAst(background.value.members.first{ it.name == "onSelect" })
                ObjectValue(background.value, mapOf(), runtimePos)
            }
            else -> throw IllegalStateException("Invalid state")
        }.also { state++ }

        private fun dumpAst(f: FunDeclaration) {
            Runtime.getLogger().logMessage("[DUMP_AST]: ---------------------")
            Runtime.getLogger().logMessage("[DUMP_AST]: AST FOR ${f.name} (arguments: ${f.params})")

            f.body.forEach { s -> dumpStmt(s) }

            Runtime.getLogger().logMessage("[DUMP_AST]: ---------------------")
        }

        private fun dumpStmt(stmt: Statement, indent: Int = 0) {
            var i = ""
            repeat(indent) { i += "  " }
            when(stmt) {
                is AssignmentStmt -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Assign to ${stmt.name}")
                    dumpExpr(stmt.expr, indent + 1)
                }
                is BreakStmt -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Break")
                }
                is ExprStmt -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Expression")
                    dumpExpr(stmt.expr, indent + 1)
                }
                is ForStmt -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> For ${stmt.name} in ")
                    dumpExpr(stmt.set, indent + 1)
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> do (for ${stmt.name} in) ")
                    stmt.body.forEach { s -> dumpStmt(s, indent + 1) }
                }
                is IfStmt -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> If")
                    dumpExpr(stmt.condition, indent + 1)
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> then")
                    stmt.bodyTrue.forEach { s -> dumpStmt(s, indent + 1) }
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> else")
                    stmt.bodyFalse?.forEach { s -> dumpStmt(s, indent + 1) } ?: Runtime.getLogger().logMessage("[DUMP_AST]: $i   -> (no else)")
                }
                is ReturnStmt -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Return")
                    stmt.expr?.let { dumpExpr(it, indent + 1) } ?: Runtime.getLogger().logMessage("[DUMP_AST]: $i   -> (no return value)")
                }
                is WhileStmt -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> While")
                    dumpExpr(stmt.condition, indent + 1)
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> do (while)")
                    stmt.body.forEach { s -> dumpStmt(s, indent + 1) }
                }
            }
        }

        private fun dumpExpr(e: Expression, indent: Int = 0) {
            var i = "";
            repeat(indent) { i += "  " }
            when(e) {
                is BinaryExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Binary ${e.op}")
                    dumpExpr(e.left, indent + 1)
                    dumpExpr(e.right, indent + 1)
                }
                is CallExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Call ${e.name}")
                    e.args.forEach { dumpExpr(it, indent + 1) }
                }
                is IndexExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Index")
                    dumpExpr(e.target, indent + 1)
                    dumpExpr(e.index, indent + 1)
                }
                is LiteralExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Literal ${e.value}")
                }
                is MappedIntExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> MappedInt")
                    dumpExpr(e.target, indent + 1)
                }
                is MemberCallExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> MemberCall ${e.member}")
                    dumpExpr(e.target, indent + 1)
                    e.args.forEach { dumpExpr(it, indent + 1) }
                }
                is MemberExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Member ${e.member}")
                    dumpExpr(e.target, indent + 1)
                }
                is RangeExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Range (inclusive? ${e.inclusive})")
                    dumpExpr(e.start, indent + 1)
                    dumpExpr(e.end, indent + 1)
                }
                is ListExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> List")
                    e.values.forEach { dumpExpr(it, indent + 1) }
                }
                is TernaryExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Ternary")
                    dumpExpr(e.cond, indent + 1)
                    dumpExpr(e.bTrue, indent + 1)
                    dumpExpr(e.bFalse, indent + 1)
                }
                is UnaryExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Unary ${e.op}")
                    dumpExpr(e.target, indent + 1)
                }
                is VariableExpression -> {
                    Runtime.getLogger().logMessage("[DUMP_AST]: $i -> Variable ${e.name}")
                }
            }
        }

        suspend fun run(onChoice: suspend (ChoiceDesc) -> Unit): Boolean {
            Runtime.getLogger().logMessage(" -> Running creation (is continuation? ${DfsRuntime.isRunning()})")
            if(state == 4 && !DfsRuntime.isRunning()) {
                // character creation should be complete
                Runtime.getLogger().logMessage("  -> Character finally finished!")
                Runtime.getCache().register(result)
                Runtime.getLogger().logMessage("  -> Character registered.")
                CharacterLoader.store(Runtime.getStorage())
                Runtime.getLogger().logMessage("  -> Characters backed up to storage.")
                return true
            }
            if(DfsRuntime.isRunning()) {
                val temp = DfsRuntime.getInstance().runUntilChoice().leftOrNull()
                if(temp != null) {
                    onChoice(temp)
                }
                else {
                    run(onChoice)
                }
            }
            else {
                val sel = selector()
                Runtime.getLogger().logMessage("   -> Starting runtime with next selector (${sel.type.name})")
                DfsRuntime.ready(sel, "onSelect", listOf(), runtimePos, this@Character.prepare())
                run(onChoice)
            }
            return false
        }

        fun provideChoice(name: String, result: Value) {
            choices[name] = result
            this@Character.choices[name] = result
            if(DfsRuntime.isRunning()) DfsRuntime.getInstance().provideChoice(result)
        }

        fun doneRunning() = state == 4 && !DfsRuntime.isRunning()
    }

    companion object {
        private val runtimePos = Pos("<runtime>", "<createCharacter>", 0, 0)

        fun abilityMod(score: Int) = (score - 10) / 2
    }
}