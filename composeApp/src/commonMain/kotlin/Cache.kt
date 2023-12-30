import java.io.File
import java.nio.file.Files

class Cache(val pth: String, val initialPath: String) {
    private val lastDir = ".last_dir"
    private var lastCachedDir: String? = null

    init {
        if(!Files.isDirectory(File(pth).toPath())) {
            File(pth).mkdirs()
        }
    }

    fun lastDir(): String {
        return lastCachedDir ?: run {
            val f = File(pth + lastDir)
            if (!f.exists()) {
                f.createNewFile()
                f.writeText(initialPath)
            }
            lastCachedDir = f.readText()
            lastCachedDir!!
        }
    }

    fun updateLastDir(update: String) {
        val f = File(pth + lastDir)
        lastCachedDir = update
        f.writeText(update)
    }
}