import java.io.Closeable
import java.util.prefs.Preferences

class DesktopCache : LocalStorage {
    private val prefs: Preferences = Preferences.userRoot().node("mageMythos")

    override fun lastLoaded(): String = prefs.get(cacheDir, System.getProperty("user.home") + "/")
    override fun onLoad(dir: String) = prefs.put(cacheDir, dir)

    companion object {
        private const val cacheDir = "cacheDir"
    }
}