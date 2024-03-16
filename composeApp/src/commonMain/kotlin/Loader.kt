import runtime.CharacterLoader
import runtime.ILoader
import runtime.Runtime
import runtime.ast.AstBuilder

suspend fun loadCharacters(loader: ILoader) {
    Runtime.getLogger().logMessage("[LD_CHAR]: Loading sources...")
    AstBuilder.loadEntireCache(loader)
    Runtime.getLogger().logMessage("[LD_CHAR]: Loading characters...")
    CharacterLoader.load(loader)
}