package runtime.ast

import runtime.ChoiceScope

class TagEffect(private val name: String, private val argCount: Int, private val onApply: (TypeDeclaration, List<Expression>, Pos) -> Unit) {
    private fun checkArgCount(args: List<Expression>, at: Pos) {
        if (args.size != argCount) {
            throw TagArgumentError(name, argCount, args.size, at)
        }
    }

    fun apply(decl: TypeDeclaration, args: List<Expression>, at: Pos) {
        checkArgCount(args, at)
        onApply(decl, args, at)
    }

    companion object {
        private val effects = sequence<TagEffect> {
            // TODO: add all
        }.associateBy { it.name }

        private val mkChoiceScope: (Pos) -> ChoiceScope = { p: Pos ->
            { _, _, _ ->
                throw SyntaxError("Can't use choice functions in tags.", p)
            }
        }

        fun applyTag(decl: TypeDeclaration, name: String, args: List<Expression>, at: Pos) {
            val effect = effects[name] ?: throw InvalidTagError(name, at)
            effect.apply(decl, args, at)
        }
    }
}