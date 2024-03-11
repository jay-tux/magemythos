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

fun Character.getAbility(args: List<Value>, pos: Pos): Value {
    checkArgCount("getAbility", args, 1, pos)
    val which = args[0].requireObject<Ability>("Ability", pos)
    return abilities.value[which]?.let { IntValue(it, pos) }
        ?: throw ArbitraryRuntimeError("No such ability: ${which.displayName} at $pos")
}

fun Character.getLevel(args: List<Value>, pos: Pos): Value {
    checkArgCount("getLevel", args, 0, pos)
    return IntValue(clazz.value.sumOf { it.level }, pos)
}

fun Character.isEquipped(args: List<Value>, pos: Pos): Value {
    checkArgCount("isEquipped", args, 1, pos)
    val what = args[0].require<ObjectValue>("object", pos)
    return when(what.type) {
        is Item -> BoolValue(inventory.value.any { it.item == what.type && it.equipped }, pos)
        is ItemTag -> BoolValue(inventory.value.any { it.item.tags.contains(what.type) && it.equipped }, pos)
        else -> throw TypeError("Item or ItemTag", what, pos)
    }
}

fun Character.getMod(args: List<Value>, pos: Pos): Value {
    checkArgCount("getMod", args, 1, pos)
    val which = args[0].requireObject<Ability>("Ability", pos)
    return abilities.value[which]?.let { IntValue((it - 10) / 2, pos) }
        ?: throw ArbitraryRuntimeError("No such ability: ${which.displayName} at $pos")
}

fun Character.setBaseAC(args: List<Value>, pos: Pos): Value {
    checkArgCount("setBaseAC", args, 1, pos)
    val newAC = args[0].require<IntValue>("int", pos).value
    setAC(base = newAC)
    return VoidValue(pos)
}

fun Character.noArmor(args: List<Value>, pos: Pos): Value {
    checkArgCount("noArmor", args, 1, pos)
    val allowShields = args[0].require<BoolValue>("bool", pos).value
    val armorTag = Runtime.getCache().typesOfKind<ItemTag>().firstOrNull { it.name == "Armor" } ?: throw ArbitraryRuntimeError("Missing ItemTag Armor (required at $pos)")
    return if(allowShields) {
        val shieldTag = Runtime.getCache().typesOfKind<ItemTag>().firstOrNull { it.name == "ShieldTag" } ?: throw ArbitraryRuntimeError("Missing ItemTag ShieldTag (required at $pos)")
        BoolValue(inventory.value.none { it.equipped && it.item.tags.contains(armorTag) && !it.item.tags.contains(shieldTag) }, pos)
    }
    else {
        BoolValue(inventory.value.none { it.equipped && it.item.tags.contains(armorTag) }, pos)
    }
}

fun Character.getSpeed(args: List<Value>, pos: Pos): Value {
    checkArgCount("getSpeed", args, 0, pos)
    return IntValue(speed.value, pos)
}

fun Character.setSpeed(args: List<Value>, pos: Pos): Value {
    checkArgCount("setSpeed", args, 1, pos)
    val newSpeed = args[0].require<IntValue>("int", pos).value
    updSpeed(newSpeed)
    return VoidValue(pos)
}

fun Character.applyASI(args: List<Value>, pos: Pos): Value {
    checkArgCount("applyASI", args, 2, pos)
    val which = args[0].requireObject<Ability>("Ability", pos)
    val amount = args[1].require<IntValue>("int", pos).value
    setAbility(
        which,
        (abilities.value[which]
            ?: throw ArbitraryRuntimeError("No such ability: ${which.displayName} at $pos")) + amount
    )
    return VoidValue(pos)
}

val profBonus = listOf(2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6)
fun Character.getProficiencyBonus(args: List<Value>, pos: Pos): Value {
    checkArgCount("getProficiencyBonus", args, 0, pos)
    return IntValue(profBonus[clazz.value.sumOf { it.level } - 1], pos)
}

fun getSkills(args: List<Value>, pos: Pos): Value {
    checkArgCount("getSkills", args, 0, pos)
    return ListValue(Runtime.getCache().typesOfKind<Skill>().map { ObjectValue(it, mapOf(), pos) }, pos)
}

fun Character.isProficient(args: List<Value>, pos: Pos): Value {
    checkArgCount("isProficient", args, 1, pos)
    val which = args[0].requireObject<Skill>("Skill", pos)
    return BoolValue(proficiencies.value.contains(which), pos)
}

fun Character.addBonus(args: List<Value>, pos: Pos): Value {
    checkArgCount("addBonus", args, 2, pos)
    val which = args[0].requireObject<Skill>("Skill", pos)
    val amount = args[1].require<IntValue>("int", pos).value
    addSkillBonus(which, amount)
    return VoidValue(pos)
}

fun Character.addSpell(args: List<Value>, pos: Pos): Value {
    checkArgCount("addSpell", args, 1, pos)
    val spell = args[0].requireObject<Spell>("Spell", pos)
    addSpell(spell)
    return VoidValue(pos)
}

fun Character.addSpells(args: List<Value>, pos: Pos): Value {
    checkArgCount("addSpells", args, 1, pos)
    val spells = args[0].require<ListValue>("list", pos).value.map { it.requireObject<Spell>("Spell", pos) }
    spells.forEach { addSpell(it) }
    return VoidValue(pos)
}

fun Character.addSpellUsing(args: List<Value>, pos: Pos): Value {
    checkArgCount("addSpellUsing", args, 2, pos)
    val spell = args[0].requireObject<Spell>("Spell", pos)
    val ability = args[1].requireObject<Ability>("Ability", pos)
    addSpell(spell, ability)
    return VoidValue(pos)
}

fun Character.addSpellsIgnoreKnown(args: List<Value>, pos: Pos): Value {
    checkArgCount("addSpells", args, 1, pos)
    val spells = args[0].require<ListValue>("list", pos).value.map { it.requireObject<Spell>("Spell", pos) }
    spells.forEach { addSpell(it) }
    Runtime.getLogger().logWarning("addSpellsIgnoreKnown() is not fully implemented yet (functions like addSpells()).")
    return VoidValue(pos)
}

fun Character.getIndex(args: List<Value>, pos: Pos): Value {
    checkArgCount("getIndex", args, 0, pos)
    Runtime.getLogger().logWarning("getIndex() is not fully implemented yet (always returns 0).")
    return IntValue(0, pos)
}

fun getSpells(args: List<Value>, pos: Pos): Value {
    checkArgCount("getSpells", args, 0, pos)
    return ListValue(Runtime.getCache().typesOfKind<Spell>().map { ObjectValue(it, mapOf(), pos) }, pos)
}

fun Character.addResistance(args: List<Value>, pos: Pos): Value {
    checkArgCount("addResistance", args, 1, pos)
    val which = args[0].requireObject<Damage>("Damage", pos)
    addResistance(which)
    return VoidValue(pos)
}

fun Character.addItemProf(args: List<Value>, pos: Pos): Value {
    checkArgCount("addItemProf", args, 1, pos)
    val which = args[0].require<ListValue>("list", pos).value
    which.forEach {
        val temp = it.require<ObjectValue>("object", pos)
        when (val t = temp.type) {
            is ItemTag -> addItemProf(t)
            is Item -> addItemProf(t)
            else -> throw TypeError("Item or ItemTag", temp, pos)
        }
    }
    return VoidValue(pos)
}

fun Character.addItemProfs(args: List<Value>, pos: Pos): Value {
    checkArgCount("addItemProfs", args, 1, pos)
    val which = args[0].require<ListValue>("list", pos).value
    which.forEach {
        val temp = it.require<ObjectValue>("object", pos)
        when (val t = temp.type) {
            is ItemTag -> addItemProf(t)
            is Item -> addItemProf(t)
            else -> throw TypeError("Item or ItemTag", temp, pos)
        }
    }
    return VoidValue(pos)
}

fun Character.addMaxHP(args: List<Value>, pos: Pos): Value {
    checkArgCount("addMaxHP", args, 1, pos)
    val amount = args[0].require<IntValue>("int", pos).value
    addMaxHp(amount)
    return VoidValue(pos)
}

fun Character.addSkillProf(args: List<Value>, pos: Pos): Value {
    checkArgCount("addSkillProf", args, 1, pos)
    val which = args[0].requireObject<Skill>("Skill", pos)
    addSkillProf(which)
    return VoidValue(pos)
}

fun Character.addSkillProfs(args: List<Value>, pos: Pos): Value {
    checkArgCount("addSkillProfs", args, 1, pos)
    args[0].require<ListValue>("list", pos).value.forEach { a ->
        addSkillProf(a.requireObject<Skill>("Skill", pos))
    }
    return VoidValue(pos)
}

fun Character.addLanguages(args: List<Value>, pos: Pos): Value {
    checkArgCount("addLanguages", args, 1, pos)
    args[0].require<ListValue>("list", pos).value.forEach { l ->
        addLanguage(l.requireObject<Language>("Language", pos))
    }
    return VoidValue(pos)
}

fun Character.addTraits(args: List<Value>, pos: Pos): Value {
    checkArgCount("addTraits", args, 1, pos)
    args[0].require<ListValue>("list", pos).value.forEach { t ->
        addTrait(t.requireObject<Trait>("Trait", pos))
    }
    return VoidValue(pos)
}

fun Character.addSaveProfs(args: List<Value>, pos: Pos): Value {
    checkArgCount("addSaveProfs", args, 1, pos)
    args[0].require<ListValue>("list", pos).value.forEach { a ->
        addSaveProf(a.requireObject<Ability>("Ability", pos))
    }
    return VoidValue(pos)
}

fun Character.addItems(args: List<Value>, pos: Pos): Value {
    checkArgCount("addItems", args, 2, pos)
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
    return VoidValue(pos)
}