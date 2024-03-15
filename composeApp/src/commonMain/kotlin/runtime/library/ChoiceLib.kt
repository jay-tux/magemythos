package runtime.library

import arrow.core.Either
import arrow.core.left
import arrow.core.right
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

fun ChoiceScope.ready(fName: String, args: List<Value>, argCount: Int, at: Pos, choiceNotMade: (name: String, pos: Pos, args: List<Value>) -> Unit): Either<Value, Unit> {
    checkArgCount(fName, args, argCount, at)
    Runtime.getLogger().logMessage("[CHOICESCOPE]: Calling $fName (${args.size}/$argCount args) at $at")
    val cName = args[0].require<StringValue>("string", at).value
    return getChoice(cName)?.left() ?: choiceNotMade(cName, Pos("<library::$fName>", 0, 0), args).right()
}

fun ChoiceScope.choose(argsPre: List<Value>, at: Pos) = ready("choose", argsPre, 3, at) { name, pos, args ->
    val title = args[1].require<StringValue>("string", pos).value
    val options = args[2].require<ListValue>("list", pos).value

    val desc = ChoiceDesc(name, title, 1, options, pos)
    this(desc)
}

fun ChoiceScope.chooseN(argsPre: List<Value>, at: Pos) = ready("chooseN", argsPre, 4, at) { name, pos, args ->
    val title = args[1].require<StringValue>("string", pos).value
    val amount = args[2].require<IntValue>("int", pos).value
    val options = args[3].require<ListValue>("list", pos).value

    val desc = ChoiceDesc(name, title, amount, options, pos)
    this(desc)
}

fun ChoiceScope.chooseLanguage(ch: Character, argsPre: List<Value>, at: Pos) = ready("chooseLanguages", argsPre, 1, at) { name, pos, _ ->
    val chosen = ch.languages.value.map { it.name }
    val options = Runtime.getCache().typesOfKind<Language>().filter { !chosen.contains(it.name) }
    val desc = ChoiceDesc(name, "Choose a language", 1, options.map { it.construct(pos) }, pos)
    this(desc)
}

fun ChoiceScope.chooseLanguages(ch: Character, argsPre: List<Value>, at: Pos) = ready("chooseLanguages", argsPre, 2, at) { name, pos, args ->
    val amount = args[1].require<IntValue>("int", pos).value
    if(amount <= 0) throw ArbitraryRuntimeError("Amount of choices must be positive (got $amount at $pos)")

    val chosen = ch.languages.value.map { it.name }
    val options = Runtime.getCache().typesOfKind<Language>().filter { !chosen.contains(it.name) }
    val desc = ChoiceDesc(name, "Choose $amount language(s)", amount, options.map { it.construct(pos) }, pos)
    this(desc)
}

fun ChoiceScope.chooseItem(argsPre: List<Value>, at: Pos) = ready("chooseItem", argsPre, 2, at) { name, pos, args ->
    val filters = args[1].require<ListValue>("list", pos).value
    val options = mutableSetOf<Item>()
    val actualFilters = mutableListOf<ItemTag>()
    filters.forEach { f ->
        when(val t = f.require<ObjectValue>("object", pos).type) {
            is ItemTag -> actualFilters.add(t)
            is Item -> options.add(t)
            else -> throw TypeError("Item or ItemTag", f, pos)
        }
    }

    Runtime.getCache().typesOfKind<Item>().filter { it.tags.containsAll(actualFilters) }.forEach { options.add(it) }
    val desc = ChoiceDesc(name, "Choose an item", 1, options.map { it.construct(pos) }, pos)
    this(desc)
}

fun ChoiceScope.chooseItemN(argsPre: List<Value>, at: Pos) = ready("chooseItemN", argsPre, 3, at) { name, pos, args ->
    val count = args[1].require<IntValue>("int", pos).value
    val filters = args[2].require<ListValue>("list", pos).value
    val options = mutableSetOf<Item>()
    val actualFilters = mutableListOf<ItemTag>()
    filters.forEach { f ->
        when(val t = f.require<ObjectValue>("object", pos).type) {
            is ItemTag -> actualFilters.add(t)
            is Item -> options.add(t)
            else -> throw TypeError("Item or ItemTag", f, pos)
        }
    }
    if(count <= 0) throw ArbitraryRuntimeError("Amount of choices must be positive (got $count at $pos)")

    Runtime.getCache().typesOfKind<Item>().filter { it.tags.containsAll(actualFilters) }.forEach { options.add(it) }
    val desc = ChoiceDesc(name, "Choose an item", count, options.map { it.construct(pos) }, pos)
    this(desc)
}

fun ChoiceScope.chooseSpellN(argsPre: List<Value>, at: Pos) = ready("chooseSpellN", argsPre, 3, at) { name, pos, args ->
    val amount = args[1].require<IntValue>("int", pos).value
    val options = args[2].require<ListValue>("list", pos).value.map { ObjectValue(it.requireObject<Spell>("Spell", pos), mapOf(), pos) }
    if(amount <= 0) throw ArbitraryRuntimeError("Amount of choices must be positive (got $amount at $pos)")

    val desc = ChoiceDesc(name, "Choose $amount spell(s)", amount, options, pos)
    this(desc)
}

fun ChoiceScope.chooseSpellFrom(argsPre: List<Value>, at: Pos) = ready("chooseSpellFrom", argsPre, 2, at) { name, pos, args ->
    val clazz = args[1].requireObject<Class>("Class", pos)
    val options = clazz.spellcaster?.spellList?.map { ObjectValue(it, mapOf(), pos) } ?: throw ArbitraryRuntimeError("Class ${clazz.displayName} is not a spellcaster class.")
    val desc = ChoiceDesc(name, "Choose a spell", 1, options, pos)
    this(desc)
}

fun ChoiceScope.chooseSkillN(argsPre: List<Value>, at: Pos) = ready("chooseSkillN", argsPre, 3, at) { name, pos, args ->
    val amount = args[1].require<IntValue>("int", pos).value
    val options = args[2].require<ListValue>("list", pos).value.map { ObjectValue(it.requireObject<Skill>("Skill", pos), mapOf(), pos) }
    if(amount <= 0) throw ArbitraryRuntimeError("Amount of choices must be positive (got $amount at $pos)")

    val desc = ChoiceDesc(name, "Choose $amount skill(s)", amount, options, pos)
    this(desc)
}