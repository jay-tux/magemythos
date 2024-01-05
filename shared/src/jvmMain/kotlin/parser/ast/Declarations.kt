package parser.ast

class DeclarationSet(
    val source: String, val deps: List<String>,
    val classes: List<ClassDeclaration>, val races: List<RaceDeclaration>,
    val subClasses: List<SubClassDeclaration>, val subRaces: List<SubRaceDeclaration>,
    val items: List<ItemDeclaration>, val spells: List<SpellDeclaration>,
    val backgrounds: List<BackgroundDeclaration>, val abilities: List<AbilityDeclaration>,
    val skills: List<SkillDeclaration>, pos: Pos
) : AstNode(pos)

sealed class Declaration(pos: Pos) : AstNode(pos)

class ClassDeclaration(val name: String, val displayName: String, val description: String, pos: Pos)
    : Declaration(pos)

class SubClassDeclaration(val name: String, val displayName: String, val subFor: String, val description: String, pos: Pos)
    : Declaration(pos)

class RaceDeclaration(val name: String, val displayName: String, val description: String, pos: Pos)
    : Declaration(pos)

class SubRaceDeclaration(val name: String, val displayName: String, val subFor: String, val description: String, pos: Pos)
    : Declaration(pos)

class ItemDeclaration(val name: String, val displayName: String, val description: String, pos: Pos)
    : Declaration(pos)

class SpellDeclaration(val name: String, val displayName: String, val description: String, pos: Pos)
    : Declaration(pos)

class BackgroundDeclaration(val name: String, val displayName: String, val description: String, pos: Pos)
    : Declaration(pos)

class AbilityDeclaration(val name: String, val displayName: String, val description: String, pos: Pos)
    : Declaration(pos)

class SkillDeclaration(val name: String, val displayName: String, val dependsOn: String, val description: String, pos: Pos)
    : Declaration(pos)