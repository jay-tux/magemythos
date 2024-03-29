import androidx.compose.runtime.mutableStateListOf
import runtime.ICache
import runtime.Type
import runtime.ast.FunDeclaration
import java.io.Closeable
import java.util.prefs.Preferences
import net.harawata.appdirs.AppDirsFactory
import runtime.Character
import runtime.ast.Streams
import runtime.ast.Variable
import java.io.File

class DesktopCache : LocalStorage, ICache, ILogger {
    private val prefs: Preferences = Preferences.userRoot().node("mageMythos")

    override fun lastLoaded(): String = prefs.get(cacheDir, System.getProperty("user.home") + "/")
    override fun onLoad(dir: String) = prefs.put(cacheDir, dir)

    override fun selectedCacheDir(): String? = prefs.get(cacheDir, "")?.let { if(it == "") null else it }
    override fun onSetCacheDir(dir: String) = prefs.put(cacheDir, dir)

    fun characterCache(): String {
        val res = prefs.get(charCache, AppDirsFactory.getInstance().getUserDataDir("mageMythos", null, null))
        File(res).mkdirs()
        prefs.put(charCache, res)
        return res
    }

    companion object {
        private const val cacheDir = "cacheDir"
        private const val charCache = "characters"

        fun mkProvider(base: String) = { src: String, file: String ->
            println("[Provider]: $src($file) -> $base/$src/$file.mm")

            val sourceStream = try {
                File("$base/$src/$file.mm").inputStream()
            } catch (e: Exception) {
                throw SourceLoadingError(src, file, "$base/$src/$file.mm")
            }

            val descStream = try {
                File("$base/$src/$file.mmstr").inputStream()
            } catch (e: Exception) {
                throw DescLoadingError(src, file, "$base/$src/$file.mmstr")
            }

            Streams(sourceStream, descStream)
        }

        fun mkLoader() = { path: String ->
            println("[Loader]: Loading $path")
            try {
                File(path).inputStream()
            } catch (e: Exception) {
                throw FileLoadingError(path)
            }
        }
    }

    val types = mutableMapOf<String, Type>()
    val functions = mutableMapOf<String, FunDeclaration>()
    val globals = mutableMapOf<String, Variable>()
    val characters = mutableStateListOf<Character>()

    override fun register(type: Type) = types.put(type.name, type).let{}
    override fun register(fn: FunDeclaration) = functions.put(fn.name, fn).let{}
    override fun register(global: Variable) = globals.put(global.name, global).let{}
    override fun register(char: Character) = characters.add(char).let{}
    override fun getType(name: String): Type? = types[name]
    override fun getFunction(name: String): FunDeclaration? = functions[name]
    override fun getGlobal(name: String): Variable? = globals[name]

    override fun typeIterator(): Iterator<Type> = types.values.iterator()
    override fun functionIterator(): Iterator<FunDeclaration> = functions.values.iterator()
    override fun globalIterator(): Iterator<Variable> = globals.values.iterator()

    fun resetCache() {
        types.clear()
        functions.clear()
        globals.clear()
        characters.clear()
    }

    enum class MessageType(val show: String) {
        INFO("Info"), ERROR("Error"), WARNING("Warning")
    }
    class Message(val message: String, val type: MessageType)
    val messages = mutableStateListOf<Message>()

    override fun logMessage(message: String) {
        messages.add(Message(message, MessageType.INFO)).let{}
        println("[MESSAGE]: $message")
    }
    override fun logWarning(message: String) {
        messages.add(Message(message, MessageType.WARNING)).let{}
        println("[WARNING]: $message")
    }
    override fun logError(message: String) {
        messages.add(Message(message, MessageType.ERROR)).let{}
        println("[ERROR]:   $message")
    }

    fun clearLog() {
        messages.clear()
    }
}