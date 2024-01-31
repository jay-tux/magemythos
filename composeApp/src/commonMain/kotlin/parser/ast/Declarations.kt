package parser.ast

class DeclarationSet(
    val source: String, val deps: List<String>,
    val classes: List<ClassDeclaration>, val races: List<RaceDeclaration>,
    val subClasses: List<SubClassDeclaration>, val subRaces: List<SubRaceDeclaration>,
    val items: List<ItemDeclaration>, val spells: List<SpellDeclaration>,
    val backgrounds: List<BackgroundDeclaration>, val abilities: List<AbilityDeclaration>,
    val skills: List<SkillDeclaration>, val freeFuncs: List<FunctionDeclaration>,
    val globals: List<VariableDeclaration>,
    pos: Pos
) : AstNode(pos)

interface Type {
    val name: String
    val displayName: String
    val description: String
    val declaredFields: List<Pair<String, Expression>>

    fun callMember(name: String, args: List<Expression>, context: Context, pos: Pos): Literal?
}

sealed class Declaration(pos: Pos) : AstNode(pos)

sealed class TypeDeclaration(
    override val name: String, override val displayName: String,
    override val description: String, override val declaredFields: List<Pair<String, Expression>>,
    private val members: Map<String, FunctionDeclaration>, pos: Pos
) :
    Declaration(pos), Type {

    override fun callMember(name: String, args: List<Expression>, context: Context, pos: Pos): Literal? =
        members[name]?.let { it.invoke(args.map { a -> a.evaluate(context) }, context, pos) }
}

class ClassDeclaration(
    name: String,
    displayName: String,
    description: String,
    declaredFields: List<Pair<String, Expression>>,
    members: Map<String, FunctionDeclaration>,
    pos: Pos
) : TypeDeclaration(name, displayName, description, declaredFields, members, pos)

class SubClassDeclaration(
    name: String,
    displayName: String,
    val subFor: String,
    description: String,
    declaredFields: List<Pair<String, Expression>>,
    members: Map<String, FunctionDeclaration>,
    pos: Pos
) : TypeDeclaration(name, displayName, description, declaredFields, members, pos)

class RaceDeclaration(
    name: String,
    displayName: String,
    description: String,
    declaredFields: List<Pair<String, Expression>>,
    members: Map<String, FunctionDeclaration>,
    pos: Pos
) : TypeDeclaration(name, displayName, description, declaredFields, members, pos)

class SubRaceDeclaration(
    name: String,
    displayName: String,
    val subFor: String,
    description: String,
    declaredFields: List<Pair<String, Expression>>,
    members: Map<String, FunctionDeclaration>,
    pos: Pos
) : TypeDeclaration(name, displayName, description, declaredFields, members, pos)

class ItemDeclaration(
    name: String,
    displayName: String,
    description: String,
    declaredFields: List<Pair<String, Expression>>,
    members: Map<String, FunctionDeclaration>,
    pos: Pos
) : TypeDeclaration(name, displayName, description, declaredFields, members, pos)

class SpellDeclaration(
    name: String,
    displayName: String,
    description: String,
    declaredFields: List<Pair<String, Expression>>,
    members: Map<String, FunctionDeclaration>,
    pos: Pos
) : TypeDeclaration(name, displayName, description, declaredFields, members, pos)

class BackgroundDeclaration(
    name: String,
    displayName: String,
    description: String,
    declaredFields: List<Pair<String, Expression>>,
    members: Map<String, FunctionDeclaration>,
    pos: Pos
) : TypeDeclaration(name, displayName, description, declaredFields, members, pos)

class AbilityDeclaration(
    name: String,
    displayName: String,
    description: String,
    declaredFields: List<Pair<String, Expression>>,
    members: Map<String, FunctionDeclaration>,
    pos: Pos
) : TypeDeclaration(name, displayName, description, declaredFields, members, pos)

class SkillDeclaration(
    name: String,
    displayName: String,
    val dependsOn: String,
    description: String,
    declaredFields: List<Pair<String, Expression>>,
    members: Map<String, FunctionDeclaration>,
    pos: Pos
) : TypeDeclaration(name, displayName, description, declaredFields, members, pos)

class FunctionDeclaration(
    val name: String,
    val args: List<String>,
    val body: List<Statement>,
    pos: Pos
) : Declaration(pos) {
    fun invoke(args: List<Literal>, context: Context, pos: Pos): Literal {
        TODO()
    }
}

class VariableDeclaration(val name: String, val initial: Expression, pos: Pos) : Declaration(pos)