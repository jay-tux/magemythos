package runtime

import runtime.ast.Pos
import runtime.ast.Value
import runtime.library.*

data class ChoiceDesc(val name: String, val title: String, val count: Int, val options: List<Value>, val requiredAt: Pos)
interface ChoiceScope {
    operator fun invoke(what: ChoiceDesc)
}

object Library {
    private object Implementations {
    }

    var character: Character? = null
    var choice: ChoiceScope? = null

    fun invokeFunction(target: String, args: List<Value>, at: Pos) = when(target) {
        "print" -> print(args)
        "getAbility" -> withCharacter("getAbility", at) { getAbility(args, at) }
        "getLevel" -> withCharacter("getLevel", at) { getLevel(args, at) }
        "isEquipped" -> withCharacter("isEquipped", at) { isEquipped(args, at) }
        "getMod" -> withCharacter("getMod", at) { getMod(args, at) }
        "setBaseAC" -> withCharacter("setBaseAC", at) { setBaseAC(args, at) }
        "noArmor" -> withCharacter("noArmor", at) { noArmor(args, at) }
        "getSpeed" -> withCharacter("getSpeed", at) { getSpeed(args, at) }
        "setSpeed" -> withCharacter("setSpeed", at) { setSpeed(args, at) }
        "applyASI" -> withCharacter("applyASI", at) { applyASI(args, at) }
        "getProficiencyBonus" -> withCharacter("getProficiencyBonus", at) { getProficiencyBonus(args, at) }
        "getSkills" -> withCharacter("getSkills", at) { getSkills(args, at) }
        "isProficient" -> withCharacter("isProficient", at) { isProficient(args, at) }
        "addBonus" -> withCharacter("addBonus", at) { addBonus(args, at) }
        "addSpell" -> withCharacter("addSpell", at) { addSpell(args, at) }
        "addSpells" -> withCharacter("addSpells", at) { addSpells(args, at) }
        "addSpellsIgnoreKnown" -> withCharacter("addSpellsIgnoreKnown", at) { addSpellsIgnoreKnown(args, at) }
        "getIndex" -> withCharacter("getIndex", at) { getIndex(args, at) }
        "getSpells" -> withCharacter("getSpells", at) { getSpells(args, at) }
        "addResistance" -> withCharacter("addResistance", at) { addResistance(args, at) }
        "addItemProf" -> withCharacter("addItemProf", at) { addItemProf(args, at) }
        "addMaxHP" -> withCharacter("addMaxHP", at) { addMaxHP(args, at) }
        "addSpellUsing" -> withCharacter("addSpellUsing", at) { addSpellUsing(args, at) }
        "addSkillProf" -> withCharacter("addSkillProf", at) { addSkillProf(args, at) }
        "addItemProfs" -> withCharacter("addItemProfs", at) { addItemProfs(args, at) }
        "addSkillProfs" -> withCharacter("addSkillProfs", at) { addSkillProfs(args, at) }
        "addLanguages" -> withCharacter("addLanguages", at) { addLanguages(args, at) }
        "addTraits" -> withCharacter("addTraits", at) { addTraits(args, at) }
        "addSaveProfs" -> withCharacter("addSaveProfs", at) { addSaveProfs(args, at) }
        "addItems" -> withCharacter("addItems", at) { addItems(args, at) }

        else -> null
    }

    fun invokeChoice(target: String, args: List<Value>, at: Pos) = when(target) {
        "choose" -> withChoices { choose(args, at) }
        "chooseN" -> withChoices { chooseN(args, at) }
        "chooseLanguage" -> withChoices { withCharacter("chooseLanguage", at) { chooseLanguage(this, args, at) } }
        "chooseLanguages" -> withChoices { withCharacter("chooseLanguages", at) { chooseLanguages(this, args, at) } }
        "chooseItem" -> withChoices { chooseItem(args, at) }
        "chooseSpellN" -> withChoices { chooseSpellN(args, at) }
        "chooseSkillN" -> withChoices { chooseSkillN(args, at) }
        "chooseSpellFrom" -> withChoices { chooseSpellFrom(args, at) }

        else -> null
    }

    private fun <T> withCharacter(name: String, at: Pos, block: Character.() -> T): T =
        character?.let { it.block() } ?: throw ScopeException(name, at)

    private fun <T> withChoices(block: ChoiceScope.() -> T): T =
        choice?.let { it.block() } ?: throw RuntimeInternalError("No choice scope available")
}