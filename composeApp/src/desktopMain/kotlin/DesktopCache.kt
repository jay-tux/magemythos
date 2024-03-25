import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import runtime.ICache
import runtime.Type
import runtime.ast.FunDeclaration
import java.util.prefs.Preferences
import net.harawata.appdirs.AppDirsFactory
import runtime.Character
import runtime.ILoader
import runtime.IStorage
import runtime.ast.Streams
import runtime.ast.Variable
import java.io.File
import java.io.InputStream
import java.io.OutputStream

class DesktopCache : LocalStorage, ICache, ILogger, ILoader, IStorage {
    private val prefs: Preferences = Preferences.userRoot().node(APP_TAG)
    private val appdirs = AppDirsFactory.getInstance()

    override fun lastLoaded(): String = prefs.get(CACHE_DIR, System.getProperty("user.home") + "/")
    override fun onLoad(dir: String) = prefs.put(CACHE_DIR, dir)

    override fun selectedCacheDir(): String? = prefs.get(CACHE_DIR, "")?.let { if(it == "") null else it }
    override fun onSetCacheDir(dir: String) = prefs.put(CACHE_DIR, dir)

    private fun characterCache(): String {
        val res = prefs.get(CHAR_CACHE, appdirs.getUserDataDir(APP_TAG, null, null))
        File(res).mkdirs()
        prefs.put(CHAR_CACHE, res)
        return res
    }

    override suspend fun loadSource(source: String, file: String): Streams {
        val base = lastLoaded()
        val sourceStream = try {
            File("$base/$source/$file.mm").inputStream()
        } catch(e: Exception) {
            throw SourceLoadingError(source, file, "$base/$source/$file.mm")
        }

        val descStream = try {
            File("$base/$source/$file.mmstr").inputStream()
        } catch(e: Exception) {
            throw DescLoadingError(source, file, "$base/$source/$file.mmstr")
        }

        return Streams(sourceStream, descStream)
    }

    override suspend fun loadSourceList(): InputStream {
        val base = lastLoaded()
        return try {
            File("$base/cache.json").inputStream()
        } catch (e: Exception) {
            throw FileLoadingError("$base/cache.json")
        }
    }

    override suspend fun loadCharacterList(): InputStream {
        val base = characterCache()
        return try {
            val f = File("$base/.cache.json")
            if(!f.exists()) {
                withContext(Dispatchers.IO) {
                    f.createNewFile()
                    f.writeText("[]")
                }
            }
            f.inputStream()
        } catch (e: Exception) {
            throw FileLoadingError("$base/.cache.json")
        }
    }

    override suspend fun saveCharacterList(): OutputStream {
        val base = characterCache()
        return try {
            File("$base/.cache.json").outputStream()
        } catch (e: Exception) {
            throw FileLoadingError("$base/.cache.json")
        }
    }

    override suspend fun loadCharacter(name: String): InputStream {
        val base = characterCache()
        return try {
            File("$base/c_$name.json").inputStream()
        } catch (e: Exception) {
            throw FileLoadingError("$base/c_$name.json")
        }
    }

    override suspend fun saveCharacter(name: String): OutputStream {
        val base = characterCache()
        return try {
            File("$base/c_$name.json").outputStream()
        } catch (e: Exception) {
            throw FileLoadingError("$base/c_$name.json")
        }
    }

    companion object {
        private const val APP_TAG = "mageMythos"
        private const val CACHE_DIR = "cacheDir"
        private const val CHAR_CACHE = "characters"
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
    override fun characterIterator(): Iterator<Character> = characters.iterator()

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