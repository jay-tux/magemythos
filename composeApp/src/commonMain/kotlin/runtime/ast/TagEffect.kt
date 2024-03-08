package runtime.ast

import runtime.Ability
import runtime.Armor
import runtime.Background
import runtime.ChoiceScope
import runtime.Class
import runtime.Damage
import runtime.DfsRuntime
import runtime.ICache
import runtime.Instantaneous
import runtime.IntOrRoll.Companion.toIOR
import runtime.Item
import runtime.ItemTag
import runtime.NoConcentration
import runtime.Pack
import runtime.Race
import runtime.Runtime
import runtime.Skill
import runtime.Spell
import runtime.SpellcasterKind
import runtime.Subclass
import runtime.Subrace
import runtime.Tool
import runtime.Trait
import runtime.Type
import runtime.TypeError
import runtime.Weapon

class TagEffect(private val name: String, private val argCount: Int, private val onApply: suspend TagEffect.(Type.TagScope, List<Expression>, Pos) -> Unit) {
    private fun checkArgCount(args: List<Expression>, at: Pos) {
        if (args.size != argCount) {
            throw TagArgumentError(name, argCount, args.size, at)
        }
    }

    suspend fun apply(scope: Type.TagScope, args: List<Expression>, at: Pos) {
        checkArgCount(args, at)
        onApply(scope, args, at)
    }

    private suspend fun evaluate(e: Expression): Value = DfsRuntime.evaluate(e, e.pos)

    private object Tags {
        val name = TagEffect("@name", 1) { scope, args, _ ->
            scope.changeName(
                evaluate(args[0]).require<StringValue>(
                    "string",
                    args[0].pos
                ).value
            )
        }

        val noDesc = TagEffect("@noDesc", 0) { scope, _, at ->
            if(scope.hasDesc()) Runtime.getLogger().logWarning("@noDesc is ignored on a type with a description (used at $at).")
            scope.changeDesc("")
        }

        val ability = TagEffect("@ability", 1) { scope, args, at ->
            scope.requireScope<Skill.SkillTagScope>(this, at).changeAbility(
                evaluate(args[0]).require<ObjectValue>("ability object", args[0].pos)
            )
        }

        val requirement = TagEffect("@requirement", 1) { scope, args, at ->
            scope.addMember(
                FunDeclaration(
                    "canChoose",
                    listOf(),
                    listOf(ReturnStmt(args[0], at)),
                    at
                )
            )
        }

        val miscAction = TagEffect("@miscAction", 2) { scope, args, at ->
            Runtime.getLogger().logWarning("@miscAction tag is not implemented yet (used at $at).") // TODO
        }

        val repeatable = TagEffect("@repeatable", 0) { scope, _, at ->
            scope.requireScope<Trait.TraitTagScope>(this, at).makeRepeatable()
        }

        val allowSubraces = TagEffect("@allowSubraces", 0) { scope, _, at ->
            scope.requireScope<Race.RaceTagScope>(this, at).enableSubrace()
        }

        val asi = TagEffect("@ASI", 1) { scope, args, at ->
            val member = listOf(
                // for(__it in args[0]) {
                //      asi(__it[0], __it[1])
                // }
                ForStmt(
                    "__it", args[0], listOf(
                        ExprStmt(
                            CallExpression(
                                "asi", listOf(
                                    IndexExpression(
                                        VariableExpression("__it", at),
                                        LiteralExpression(IntValue(0, at), at),
                                        at
                                    ),
                                    IndexExpression(
                                        VariableExpression("__it", at),
                                        LiteralExpression(IntValue(1, at), at),
                                        at
                                    )
                                ), at
                            ),
                            at
                        )
                    ), at
                )
            )

            when(scope) {
                is Race.RaceTagScope -> scope.appendOrCreateMember("onGain", member)
                is Subrace.SubraceTagScope -> scope.appendOrCreateMember("onGain", member)
                else -> throw TagInvalidReceiverError(name, scope.kind(), at)
            }
        }

        val size = TagEffect("@size", 1) { scope, args, at ->
            scope.requireScope<Race.RaceTagScope>(this, at).setSize(
                evaluate(args[0]).require<ObjectValue>("size object", args[0].pos)
            )
        }

        val languages = TagEffect("@languages", 1) { scope, args, at ->
            val member = listOf(
                ExprStmt(
                    CallExpression(
                        "addLanguage", listOf(
                            args[0]
                        ), at
                    ),
                    at
                )
            )
            when(scope) {
                is Race.RaceTagScope -> scope.appendOrCreateMember(
                    "onGain", member
                )
                is Subrace.SubraceTagScope -> scope.appendOrCreateMember(
                    "onGain", member
                )
                else -> throw TagInvalidReceiverError(name, scope.kind(), at)
            }
        }

        val traits = TagEffect("@traits", 1) { scope, args, at ->
            val member = listOf(
                ExprStmt(
                    CallExpression(
                        "addTraits", listOf(
                            args[0]
                        ), at
                    ),
                    at
                )
            )
            when(scope) {
                is Race.RaceTagScope -> scope.appendOrCreateMember(
                    "onGain", member
                )
                is Subrace.SubraceTagScope -> scope.appendOrCreateMember(
                    "onGain", member
                )
                is Subclass.SubclassTagScope -> scope.setTraits(
                    evaluate(args[0]).require<ListValue>("list", args[0].pos)
                )
                else -> throw TagInvalidReceiverError(name, scope.kind(), at)
            }
        }

        val subraceFor = TagEffect("@subraceFor", 1) { scope, args, at ->
            scope.requireScope<Subrace.SubraceTagScope>(this, at).setBaseRace(
                evaluate(args[0]).require<ObjectValue>("race object", args[0].pos)
            )
        }

        val kind = TagEffect("@kind", 1) { scope, args, at ->
            scope.requireScope<ItemTag.ItemTagScope>(this, at).setKind(
                evaluate(args[0]).require<ObjectValue>("item kind object", args[0].pos)
            )
        }

        val value = TagEffect("@value", 1) { scope, args, at ->
            scope.requireScope<Item.ItemScope>(this, at).setCost(
                evaluate(args[0]).require<CurrencyValue>("currency", args[0].pos)
            )
        }

        val weight = TagEffect("@weight", 1) { scope, args, at ->
            scope.requireScope<Item.ItemScope>(this, at).setWeight(
                evaluate(args[0]).require<FloatValue>("float", args[0].pos).value
            )
        }

        val tag = TagEffect("@tag", 1) { scope, args, at ->
            scope.requireScope<Item.ItemScope>(this, at).addTag(
                evaluate(args[0]).require<ObjectValue>("item tag object", args[0].pos)
            )
        }

        val armor = TagEffect("@armor", 4) { scope, args, at ->
            scope.requireScope<Item.ItemScope>(this, at).addData(
                Armor(
                    evaluate(args[0]).require<IntValue>("int", args[0].pos).value,
                    evaluate(args[1]).require<IntValue>("int", args[1].pos).value,
                    evaluate(args[2]).require<IntValue>("int", args[2].pos).value,
                    evaluate(args[3]).require<BoolValue>("bool", args[3].pos).value
                )
            )
        }

        val tool = TagEffect("@tool", 0) { scope, _, at ->
            scope.requireScope<Item.ItemScope>(this, at).addData(Tool)
        }

        val modAC = TagEffect("@modAC", 1) { scope, args, at ->
            Runtime.getLogger().logWarning("@modAC tag is not implemented yet (used at $at).") // TODO
        }

        val weapon = TagEffect("@weapon", 4) { scope, args, at ->
            scope.requireScope<Item.ItemScope>(this, at).addData(
                Weapon(
                    evaluate(args[0]).require<ObjectValue>("item tag object", args[0].pos).type.let {
                        it as? ItemTag ?: throw InvalidObjectTypeError("ItemTag", it.javaClass.simpleName, args[0].pos)
                    },
                    evaluate(args[1]).require<ObjectValue>("item tag object", args[1].pos).type.let {
                        it as? ItemTag ?: throw InvalidObjectTypeError("ItemTag", it.javaClass.simpleName, args[0].pos)
                    },
                    evaluate(args[2]).let {
                        it.requireOrNull<RollValue>()?.toIOR() ?: it.require<IntValue>("roll or int", args[2].pos).toIOR()
                    },
                    evaluate(args[3]).require<ObjectValue>("damage object", args[3].pos).type.let {
                        it as? Damage ?: throw InvalidObjectTypeError("Damage", it.javaClass.simpleName, args[0].pos)
                    }
                )
            )
        }

        val inheritDesc = TagEffect("@inheritDesc", 0) { scope, _, at ->
            scope.requireScope<Item.ItemScope>(this, at).let {
                if(it.hasDesc()) Runtime.getLogger().logWarning("@inheritDesc is ignored on an Item with a description (used at $at).")
                it.tags().let { tags ->
                    if(tags.size != 1) throw ArbitraryAstError("@inheritDesc tag is only allowed on an Item with exactly one @tag tag.")
                    else it.changeDesc(tags[0].description)
                }
            }
        }

        val per = TagEffect("@per", 1) { scope, args, at ->
            scope.requireScope<Item.ItemScope>(this, at).setPer(
                evaluate(args[0]).require<IntValue>("int", args[0].pos).value
            )
        }

        val pack = TagEffect("@pack", 1) { scope, args, at ->
            scope.requireScope<Item.ItemScope>(this, at).addData(
                Pack(
                    evaluate(args[0]).require<ListValue>("list", args[0].pos).value.map {
                        it.require<ObjectValue>("item object", it.pos)
                    }
                )
            )
        }

        val charges = TagEffect("@charges", 2) { scope, args, at ->
            Runtime.getLogger().logWarning("@charges tag is not implemented yet (used at $at).") // TODO
        }

        val bonusAction = TagEffect("@bonusAction", 0) { scope, args, at ->
            Runtime.getLogger().logWarning("@bonusAction tag is not implemented yet (used at $at).") // TODO
        }

        val descLevelDep = TagEffect("@descLevelDep", 1) { scope, args, at ->
            scope.changeDesc("") // guarantee to the system that a description will be available later
            scope.appendOrCreateMember("onLevelUp", listOf(
                ExprStmt(
                    CallExpression(
                        "setDesc", listOf(
                            args[0]
                        ), at
                    ),
                    at
                )
            ), listOf("level"))
        }

        val hitDie = TagEffect("@hitDie", 1) { scope, args, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).setHitDie(
                evaluate(args[0]).require<DiceValue>("dice", args[0].pos)
            )
        }

        val armorProf = TagEffect("@armorProf", 1) { scope, args, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).appendOrCreateMember(
                "onSelect", listOf(
                    ExprStmt(
                        CallExpression(
                            "addArmorProficiencies", listOf(
                                args[0]
                            ), at
                        ),
                        at
                    )
                )
            )
        }

        val weaponProf = TagEffect("@weaponProf", 1) { scope, args, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).appendOrCreateMember(
                "onSelect", listOf(
                    ExprStmt(
                        CallExpression(
                            "addWeaponProficiencies", listOf(
                                args[0]
                            ), at
                        ),
                        at
                    )
                )
            )
        }

        val toolProf = TagEffect("@toolProf", 1) { scope, args, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).appendOrCreateMember(
                "onSelect", listOf(
                    ExprStmt(
                        CallExpression(
                            "addToolProficiencies", listOf(
                                args[0]
                            ), at
                        ),
                        at
                    )
                )
            )
        }

        val savingThrowProf = TagEffect("@savingThrowProf", 1) { scope, args, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).appendOrCreateMember(
                "onSelect", listOf(
                    ExprStmt(
                        CallExpression(
                            "addSaveProficiencies", listOf(
                                args[0]
                            ), at
                        ),
                        at
                    )
                )
            )
        }

        val skillProf = TagEffect("@skillProf", 2) { scope, args, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).appendOrCreateMember(
                "onSelect", listOf(
                    ExprStmt(
                        CallExpression(
                            "addSkillProficiencies", listOf(
                                CallExpression(
                                    "chooseN", listOf(
                                        args[0],
                                        args[1]
                                    ),
                                    at
                                )
                            ), at
                        ),
                        at
                    )
                )
            )
        }

        val startEquipment = TagEffect("@startEquipment", 1) { scope, args, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).appendOrCreateMember(
                "onSelect", listOf(
                    ExprStmt(
                        CallExpression(
                            "addItems", listOf(
                                args[0]
                            ), at
                        ),
                        at
                    )
                )
            )
        }

        val traitsByLevel = TagEffect("@traitsByLevel", 1) { scope, args, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).appendOrCreateMember(
                "onLevelUp", listOf(
                    ExprStmt(
                        CallExpression(
                            "addTraits", listOf(
                                IndexExpression(
                                    args[0],
                                    VariableExpression("level", at),
                                    at
                                )
                            ), at
                        ),
                        at
                    )
                ), listOf("level")
            )
        }

        val reaction = TagEffect("@reaction", 2) { scope, args, at ->
            Runtime.getLogger().logWarning("@reaction tag is not implemented yet (used at $at).") // TODO
        }

        val subclassFor = TagEffect("@subclassFor", 1) { scope, args, at ->
            scope.requireScope<Subclass.SubclassTagScope>(this, at).setBaseClass(
                evaluate(args[0]).require<ObjectValue>("class object", args[0].pos)
            )
        }

        val action = TagEffect("@action", 0) { scope, _, at ->
            Runtime.getLogger().logWarning("@action tag is not implemented yet (used at $at).") // TODO
        }

        val casterKnown = TagEffect("@casterKnown", 5) { scope, args, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).let { s ->
                val ability = evaluate(args[0]).castThrough<Ability>()
                val slotsByLevel = evaluate(args[1]).require<ListValue>("list", args[1].pos).value.map {
                    it.require<ListValue>("list", it.pos).value.map { c -> c.require<IntValue>("int", c.pos).value }
                }
                val spellList = evaluate(args[2]).require<ListValue>("list", args[2].pos).value.map {
                    it.castThrough<Spell>()
                }
                val cantripsByLevel = evaluate(args[3]).require<ListValue>("list", args[3].pos).value.map {
                    it.require<IntValue>("int", it.pos).value
                }
                val knownByLevel = evaluate(args[4]).require<ListValue>("list", args[4].pos).value.map {
                    it.require<IntValue>("int", it.pos).value
                }

                s.setCaster(SpellcasterKind.KnownCaster(ability, slotsByLevel, spellList, cantripsByLevel, knownByLevel))
            }
        }

        val ritualCasting = TagEffect("@ritualCasting", 0) { scope, _, at ->
            scope.requireScope<Class.ClassTagScope>(this, at).enableRitualCasting()
        }

        val usesCharges = TagEffect("@usesCharges", 2) { scope, args, at ->
            Runtime.getLogger().logWarning("@usesCharges tag is not implemented yet (used at $at).") // TODO
        }

        val rangedSpellAttack = TagEffect("@rangedSpellAttack", 7) { scope, args, at ->
            Runtime.getLogger().logWarning("@rangedSpellAttack tag is not implemented yet (used at $at).") // TODO
        }

        val rangedSpellDC = TagEffect("@rangedSpellDC", 8) { scope, args, at ->
            Runtime.getLogger().logWarning("@rangedSpellDc tag is not implemented yet (used at $at).") // TODO
        }

        val miscSpell = TagEffect("@miscSpell", 5) { scope, args, at ->
            Runtime.getLogger().logWarning("@miscSpell tag is not implemented yet (used at $at).") // TODO
        }

        val instant = TagEffect("@instant", 0) { scope, _, at ->
            scope.requireScope<Spell.SpellTagScope>(this, at).setDuration(Instantaneous)
        }

        val duration = TagEffect("@duration", 1) { scope, args, at ->
            scope.requireScope<Spell.SpellTagScope>(this, at).setDuration(
                NoConcentration(evaluate(args[0]).require<StringValue>("string", args[0].pos).value)
            )
        }

        val castingTime = TagEffect("@castingTime", 1) { scope, args, at ->
            Runtime.getLogger().logWarning("@castingTime tag is not implemented yet (used at $at).") // TODO
        }

        val school = TagEffect("@school", 1) { scope, args, at ->
            scope.requireScope<Spell.SpellTagScope>(this, at).setSchool(
                evaluate(args[0]).require<ObjectValue>("spellschool object", args[0].pos)
            )
        }

        val bgSkills = TagEffect("@bgSkills", 1) { scope, args, at ->
            scope.requireScope<Background.BackgroundTagScope>(this, at).appendOrCreateMember("onSelect", listOf(
                ExprStmt(
                    CallExpression(
                        "addSkillProficiencies", listOf(
                            args[0]
                        ), at
                    ),
                    at
                )
            ), listOf())
        }

        val bgLanguages = TagEffect("@bgLanguages", 1) { scope, args, at ->
            scope.requireScope<Background.BackgroundTagScope>(this, at).appendOrCreateMember("onSelect", listOf(
                ExprStmt(
                    CallExpression(
                        "addLanguages", listOf(
                            args[0]
                        ), at
                    ),
                    at
                )
            ), listOf())
        }

        val feature = TagEffect("@feature", 1) { scope, args, at ->
            scope.requireScope<Background.BackgroundTagScope>(this, at).appendOrCreateMember("onSelect", listOf(
                ExprStmt(
                    CallExpression(
                        "addTraits", listOf(
                            args[0]
                        ), at
                    ),
                    at
                )
            ), listOf())
        }
        
        val bgEquip = TagEffect("@bgEquip", 1) { scope, args, at ->
            scope.requireScope<Background.BackgroundTagScope>(this, at).appendOrCreateMember("onSelect", listOf(
                ExprStmt(
                    CallExpression(
                        "addItems", listOf(
                            args[0]
                        ), at
                    ),
                    at
                )
            ), listOf())
        }
    }

    companion object {
        private inline fun <reified T : Type.TagScope> Type.TagScope.requireScope(eff: TagEffect, at: Pos): T = this as? T
            ?: throw TagInvalidReceiverError(eff.name, kind(), at)

        private val effects = sequence {
            yield(Tags.name); yield(Tags.noDesc); yield(Tags.ability)
            yield(Tags.requirement); yield(Tags.miscAction); yield(Tags.repeatable)
            yield(Tags.allowSubraces); yield(Tags.asi); yield(Tags.size)
            yield(Tags.languages); yield(Tags.traits); yield(Tags.subraceFor)
            yield(Tags.kind); yield(Tags.value); yield(Tags.weight); yield(Tags.tag)
            yield(Tags.armor); yield(Tags.modAC); yield(Tags.weapon)
            yield(Tags.inheritDesc); yield(Tags.per); yield(Tags.pack)
            yield(Tags.charges); yield(Tags.bonusAction); yield(Tags.descLevelDep)
            yield(Tags.hitDie); yield(Tags.armorProf); yield(Tags.weaponProf)
            yield(Tags.toolProf); yield(Tags.savingThrowProf); yield(Tags.skillProf)
            yield(Tags.startEquipment); yield(Tags.traitsByLevel); yield(Tags.reaction)
            yield(Tags.subclassFor); yield(Tags.action); yield(Tags.casterKnown)
            yield(Tags.ritualCasting); yield(Tags.usesCharges); yield(Tags.tool)
            yield(Tags.rangedSpellAttack); yield(Tags.rangedSpellDC); yield(Tags.miscSpell)
            yield(Tags.instant); yield(Tags.duration); yield(Tags.castingTime)
            yield(Tags.school); yield(Tags.bgSkills); yield(Tags.bgLanguages)
            yield(Tags.feature); yield(Tags.bgEquip)
        }.associateBy { it.name }

        suspend fun applyTag(
            scope: Type.TagScope,
            name: String,
            args: List<Expression>,
            at: Pos
        ) {
            val effect = effects[name] ?: throw InvalidTagError(name, at)
            effect.apply(scope, args, at)
        }

        private inline fun <reified T> Value.castThrough(): T = (this as? ObjectValue ?: throw TypeError("object", this, pos)).type as? T
            ?: throw InvalidObjectTypeError(T::class.java.simpleName, this.type.javaClass.simpleName, pos)
    }
}