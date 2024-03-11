package runtime.library

import runtime.ArbitraryRuntimeError
import runtime.ChoiceScope
import runtime.ast.Pos
import runtime.ast.Value
import runtime.Character
import runtime.ChoiceDesc
import runtime.Class
import runtime.Item
import runtime.ItemTag
import runtime.Language
import runtime.Runtime
import runtime.Skill
import runtime.Spell
import runtime.TypeError
import runtime.ast.IntValue
import runtime.ast.ListValue
import runtime.ast.ObjectValue
import runtime.ast.StringValue
import runtime.typesOfKind

fun ChoiceScope.choose(args: List<Value>, at: Pos) {
    checkArgCount("choose", args, 3, at)
    val name = args[0].require<StringValue>("string", at).value
    val title = args[1].require<StringValue>("string", at).value
    val options = args[2].require<ListValue>("list", at).value

    val desc = ChoiceDesc(name, title, 1, options, at)
    this(desc)
}

fun ChoiceScope.chooseN(args: List<Value>, at: Pos) {
    checkArgCount("chooseN", args, 4, at)
    val name = args[0].require<StringValue>("string", at).value
    val title = args[1].require<StringValue>("string", at).value
    val amount = args[2].require<IntValue>("int", at).value
    val options = args[3].require<ListValue>("list", at).value

    val desc = ChoiceDesc(name, title, amount, options, at)
    this(desc)
}

fun ChoiceScope.chooseLanguage(ch: Character, args: List<Value>, at: Pos) {
    checkArgCount("chooseLanguages", args, 1, at)
    val name = args[0].require<StringValue>("string", at).value

    val chosen = ch.languages.value.map { it.name }
    val options = Runtime.getCache().typesOfKind<Language>().filter { !chosen.contains(it.name) }
    val desc = ChoiceDesc(name, "Choose a language", 1, options.map { it.construct(at) }, at)
    this(desc)
}

fun ChoiceScope.chooseLanguages(ch: Character, args: List<Value>, at: Pos) {
    checkArgCount("chooseLanguages", args, 2, at)
    val name = args[0].require<StringValue>("string", at).value
    val amount = args[1].require<IntValue>("int", at).value
    if(amount <= 0) throw ArbitraryRuntimeError("Amount of choices must be positive (got $amount at $at)")

    val chosen = ch.languages.value.map { it.name }
    val options = Runtime.getCache().typesOfKind<Language>().filter { !chosen.contains(it.name) }
    val desc = ChoiceDesc(name, "Choose $amount language(s)", amount, options.map { it.construct(at) }, at)
    this(desc)
}

fun ChoiceScope.chooseItem(args: List<Value>, at: Pos) {
    checkArgCount("chooseItem", args, 2, at)
    val name = args[0].require<StringValue>("string", at).value
    val filters = args[1].require<ListValue>("list", at).value
    val options = mutableSetOf<Item>()
    val actualFilters = mutableListOf<ItemTag>()
    filters.forEach { f ->
        when(val t = f.require<ObjectValue>("object", at).type) {
            is ItemTag -> actualFilters.add(t)
            is Item -> options.add(t)
            else -> throw TypeError("Item or ItemTag", f, at)
        }
    }

    Runtime.getCache().typesOfKind<Item>().filter { it.tags.containsAll(actualFilters) }.forEach { options.add(it) }
    val desc = ChoiceDesc(name, "Choose an item", 1, options.map { it.construct(at) }, at)
    this(desc)
}

fun ChoiceScope.chooseSpellN(args: List<Value>, at: Pos) {
    checkArgCount("chooseSpellN", args, 3, at)
    val name = args[0].require<StringValue>("string", at).value
    val amount = args[1].require<IntValue>("int", at).value
    val options = args[2].require<ListValue>("list", at).value.map { ObjectValue(it.requireObject<Spell>("Spell", at), mapOf(), at) }
    if(amount <= 0) throw ArbitraryRuntimeError("Amount of choices must be positive (got $amount at $at)")

    val desc = ChoiceDesc(name, "Choose $amount spell(s)", amount, options, at)
    this(desc)
}

fun ChoiceScope.chooseSpellFrom(args: List<Value>, at: Pos) {
    checkArgCount("chooseSpellFrom", args, 2, at)
    val name = args[0].require<StringValue>("string", at).value
    val clazz = args[1].requireObject<Class>("Class", at)
    val options = clazz.spellcaster?.spellList?.map { ObjectValue(it, mapOf(), at) } ?: throw ArbitraryRuntimeError("Class ${clazz.displayName} is not a spellcaster class.")
    val desc = ChoiceDesc(name, "Choose a spell", 1, options, at)
    this(desc)
}

fun ChoiceScope.chooseSkillN(args: List<Value>, at: Pos) {
    checkArgCount("chooseSkillN", args, 3, at)
    val name = args[0].require<StringValue>("string", at).value
    val amount = args[1].require<IntValue>("int", at).value
    val options = args[2].require<ListValue>("list", at).value.map { ObjectValue(it.requireObject<Skill>("Skill", at), mapOf(), at) }
    if(amount <= 0) throw ArbitraryRuntimeError("Amount of choices must be positive (got $amount at $at)")

    val desc = ChoiceDesc(name, "Choose $amount skill(s)", amount, options, at)
    this(desc)
}