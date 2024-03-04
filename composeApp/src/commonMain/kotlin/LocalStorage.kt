interface LocalStorage {
    fun lastLoaded(): String?
    fun onLoad(dir: String)

    fun selectedCacheDir(): String?
    fun onSetCacheDir(dir: String)
}