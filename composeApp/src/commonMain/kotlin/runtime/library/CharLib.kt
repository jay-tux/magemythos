package runtime.library

import runtime.Ability
import runtime.ArbitraryRuntimeError
import runtime.Library
import runtime.ast.IntValue
import runtime.ast.Pos
import runtime.ast.Value
import runtime.Character
import runtime.Damage
import runtime.Item
import runtime.ItemTag
import runtime.Language
import runtime.Runtime
import runtime.Skill
import runtime.Spell
import runtime.Trait
import runtime.TypeError
import runtime.ast.BoolValue
import runtime.ast.ListValue
import runtime.ast.ObjectValue
import runtime.ast.VoidValue
import runtime.typesOfKind

fun Character.readyChar(fName: String, args: List<Value>, argCount: Int, pos: Pos, body: Character.(List<Value>, Pos) -> Value): Value {
    checkArgCount(fName, args, argCount, pos)
    Runtime.getLogger().logMessage("[CHARSCOPE]: Calling $fName (${args.size}/$argCount args) at $pos")
    return body(args, Pos("<library>", "<$fName>", 0, 0))
}

fun Character.getAbility(argsPre: List<Value>, at: Pos): Value = readyChar("getAbility", argsPre, 1, at) { args, pos ->
    val which = args[0].requireObject<Ability>("Ability", pos)
    abilities.value[which]?.let { IntValue(it, pos) }
        ?: throw ArbitraryRuntimeError("No such ability: ${which.displayName} at $pos")
}

fun Character.getLevel(argsPre: List<Value>, at: Pos): Value = readyChar("getLevel", argsPre, 0, at) { _, pos ->
    IntValue(clazz.value.sumOf { it.level }, pos)
}

fun Character.isEquipped(argsPre: List<Value>, at: Pos): Value = readyChar("isEquipped", argsPre, 1, at) { args, pos ->
    val what = args[0].require<ObjectValue>("object", pos)
    when(what.type) {
        is Item -> BoolValue(inventory.value.any { it.item == what.type && it.equipped }, pos)
        is ItemTag -> BoolValue(inventory.value.any { it.item.tags.contains(what.type) && it.equipped }, pos)
        else -> throw TypeError("Item or ItemTag", what, pos)
    }
}

fun Character.getMod(argsPre: List<Value>, at: Pos): Value = readyChar("getMod", argsPre, 1, at) { args, pos ->
    val which = args[0].requireObject<Ability>("Ability", pos)
    abilities.value[which]?.let { IntValue((it - 10) / 2, pos) }
        ?: throw ArbitraryRuntimeError("No such ability: ${which.displayName} at $pos")
}

fun Character.setBaseAC(argsPre: List<Value>, at: Pos): Value = readyChar("setBaseAC", argsPre, 1, at) { args, pos ->
    val newAC = args[0].require<IntValue>("int", pos).value
    setAC(base = newAC)
    VoidValue(pos)
}

fun Character.noArmor(argsPre: List<Value>, at: Pos): Value = readyChar("noArmor", argsPre, 1, at) { args, pos ->
    val allowShields = args[0].require<BoolValue>("bool", pos).value
    val armorTag = Runtime.getCache().typesOfKind<ItemTag>().firstOrNull { it.name == "Armor" } ?: throw ArbitraryRuntimeError("Missing ItemTag Armor (required at $pos)")
    if(allowShields) {
        val shieldTag = Runtime.getCache().typesOfKind<ItemTag>().firstOrNull { it.name == "ShieldTag" } ?: throw ArbitraryRuntimeError("Missing ItemTag ShieldTag (required at $pos)")
        BoolValue(inventory.value.none { it.equipped && it.item.tags.contains(armorTag) && !it.item.tags.contains(shieldTag) }, pos)
    }
    else {
        BoolValue(inventory.value.none { it.equipped && it.item.tags.contains(armorTag) }, pos)
    }
}

fun Character.getSpeed(argsPre: List<Value>, at: Pos): Value = readyChar("getSpeed", argsPre, 0, at) { _, pos ->
    IntValue(speed.value, pos)
}

fun Character.setSpeed(argsPre: List<Value>, at: Pos): Value = readyChar("setSpeed", argsPre, 1, at) { args, pos ->
    val newSpeed = args[0].require<IntValue>("int", pos).value
    updSpeed(newSpeed)
    VoidValue(pos)
}

fun Character.applyASI(argsPre: List<Value>, at: Pos): Value = readyChar("applyASI", argsPre, 2, at) { args, pos ->
    val which = args[0].requireObject<Ability>("Ability", pos)
    val amount = args[1].require<IntValue>("int", pos).value
    setAbility(
        which,
        (abilities.value[which]
            ?: throw ArbitraryRuntimeError("No such ability: ${which.displayName} at $pos")) + amount
    )
    VoidValue(pos)
}

val profBonus = listOf(2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6)
fun Character.getProficiencyBonus(argsPre: List<Value>, at: Pos): Value = readyChar("getProficiencyBonus", argsPre, 0, at) { _, pos ->
    IntValue(profBonus[clazz.value.sumOf { it.level } - 1], pos)
}

fun Character.getSkills(argsPre: List<Value>, at: Pos): Value = readyChar("getSkills", argsPre, 0, at) { _, pos ->
    ListValue(Runtime.getCache().typesOfKind<Skill>().map { ObjectValue(it, mapOf(), pos) }, pos)
}

fun Character.isProficient(argsPre: List<Value>, at: Pos): Value = readyChar("isProficient", argsPre, 1, at) { args, pos ->
    val which = args[0].requireObject<Skill>("Skill", pos)
    BoolValue(proficiencies.value.contains(which), pos)
}

fun Character.addBonus(argsPre: List<Value>, at: Pos): Value = readyChar("addBonus", argsPre, 2, at) { args, pos ->
    val which = args[0].requireObject<Skill>("Skill", pos)
    val amount = args[1].require<IntValue>("int", pos).value
    addSkillBonus(which, amount)
    VoidValue(pos)
}

fun Character.addSpell(argsPre: List<Value>, at: Pos): Value = readyChar("addSpell", argsPre, 1, at) { args, pos ->
    val spell = args[0].requireObject<Spell>("Spell", pos)
    addSpell(spell)
    VoidValue(pos)
}

fun Character.addSpells(argsPre: List<Value>, at: Pos): Value = readyChar("addSpells", argsPre, 1, at) { args, pos ->
    val spells = args[0].require<ListValue>("list", pos).value.map { it.requireObject<Spell>("Spell", pos) }
    spells.forEach { addSpell(it) }
    VoidValue(pos)
}

fun Character.addSpellUsing(argsPre: List<Value>, at: Pos): Value = readyChar("addSpellUsing", argsPre, 2, at) { args, pos ->
    val spell = args[0].requireObject<Spell>("Spell", pos)
    val ability = args[1].requireObject<Ability>("Ability", pos)
    addSpell(spell, ability)
    VoidValue(pos)
}

fun Character.addSpellsIgnoreKnown(argsPre: List<Value>, at: Pos): Value = readyChar("addSpells", argsPre, 1, at) { args, pos ->
    val spells = args[0].require<ListValue>("list", pos).value.map { it.requireObject<Spell>("Spell", pos) }
    spells.forEach { addSpell(it) }
    Runtime.getLogger().logWarning("addSpellsIgnoreKnown() is not fully implemented yet (functions like addSpells()).")
    VoidValue(pos)
}

fun Character.getIndex(argsPre: List<Value>, at: Pos): Value = readyChar("getIndex", argsPre, 0, at) { _, pos ->
    Runtime.getLogger().logWarning("getIndex() is not fully implemented yet (always returns 0).")
    IntValue(0, pos)
}

fun Character.getSpells(argsPre: List<Value>, at: Pos): Value = readyChar("getSpells", argsPre, 0, at) { _, pos ->
    ListValue(Runtime.getCache().typesOfKind<Spell>().map { ObjectValue(it, mapOf(), pos) }, pos)
}

fun Character.addResistance(argsPre: List<Value>, at: Pos): Value = readyChar("addResistance", argsPre, 1, at) { args, pos ->
    val which = args[0].requireObject<Damage>("Damage", pos)
    addResistance(which)
    VoidValue(pos)
}

fun Character.addItemProf(argsPre: List<Value>, at: Pos): Value = readyChar("addItemProf", argsPre, 1, at) { args, pos ->
    val which = args[0].require<ListValue>("list", pos).value
    which.forEach {
        val temp = it.require<ObjectValue>("object", pos)
        when (val t = temp.type) {
            is ItemTag -> addItemProf(t)
            is Item -> addItemProf(t)
            else -> throw TypeError("Item or ItemTag", temp, pos)
        }
    }
    VoidValue(pos)
}

fun Character.addItemProfs(argsPre: List<Value>, at: Pos): Value = readyChar("addItemProfs", argsPre, 1, at) { args, pos ->
    val which = args[0].require<ListValue>("list", pos).value
    which.forEach {
        val temp = it.require<ObjectValue>("object", pos)
        when (val t = temp.type) {
            is ItemTag -> addItemProf(t)
            is Item -> addItemProf(t)
            else -> throw TypeError("Item or ItemTag", temp, pos)
        }
    }
    VoidValue(pos)
}

fun Character.addMaxHP(argsPre: List<Value>, at: Pos): Value = readyChar("addMaxHP", argsPre, 1, at) { args, pos ->
    val amount = args[0].require<IntValue>("int", pos).value
    addMaxHp(amount)
    VoidValue(pos)
}

fun Character.addSkillProf(argsPre: List<Value>, at: Pos): Value = readyChar("addSkillProf", argsPre, 1, at) { args, pos ->
    val which = args[0].requireObject<Skill>("Skill", pos)
    addSkillProf(which)
    VoidValue(pos)
}

fun Character.addSkillProfs(argsPre: List<Value>, at: Pos): Value = readyChar("addSkillProfs", argsPre, 1, at) { args, pos ->
    args[0].require<ListValue>("list", pos).value.forEach { a ->
        addSkillProf(a.requireObject<Skill>("Skill", pos))
    }
    VoidValue(pos)
}

fun Character.addLanguages(argsPre: List<Value>, at: Pos): Value = readyChar("addLanguages", argsPre, 1, at) { args, pos ->
    args[0].require<ListValue>("list", pos).value.forEach { l ->
        addLanguage(l.requireObject<Language>("Language", pos))
    }
    VoidValue(pos)
}

fun Character.addTraits(argsPre: List<Value>, at: Pos): Value = readyChar("addTraits", argsPre, 1, at) { args, pos ->
    args[0].require<ListValue>("list", pos).value.forEach { t ->
        addTrait(t.requireObject<Trait>("Trait", pos))
    }
    VoidValue(pos)
}

fun Character.addSaveProfs(argsPre: List<Value>, at: Pos): Value = readyChar("addSaveProfs", argsPre, 1, at) { args, pos ->
    args[0].require<ListValue>("list", pos).value.forEach { a ->
        addSaveProf(a.requireObject<Ability>("Ability", pos))
    }
    VoidValue(pos)
}

fun Character.addItems(argsPre: List<Value>, at: Pos): Value = readyChar("addItems", argsPre, 2, at) { args, pos ->
    args[0].require<ListValue>("list", pos).value.forEach { i ->
        when(i) {
            is ObjectValue -> addItem(i.requireObject("Item", pos), 1)
            is ListValue -> i.value.forEach { j ->
                when(j) {
                    is ObjectValue -> addItem(j.requireObject("Item", pos), 1)
                    else -> throw TypeError("Item", j, pos)
                }
            }
            else -> throw TypeError("Item or list of Items", i, pos)
        }
    }
    VoidValue(pos)
}