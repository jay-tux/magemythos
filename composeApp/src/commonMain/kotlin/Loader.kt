import runtime.CharacterLoader
import runtime.ILoader
import runtime.Runtime
import runtime.ast.AstBuilder

suspend fun loadCharacters(loader: ILoader) {
    try {
        Runtime.getLogger().logMessage("[LD_CHAR]: Loading sources...")
        AstBuilder.loadEntireCache(loader)
        Runtime.getLogger().logMessage("[LD_CHAR]: Loading characters...")
        CharacterLoader.load(loader)
    } catch (e: Exception) {
        Runtime.getLogger().logError("[LD_CHAR]: Failed to load characters: ${e.message}")
    }
}