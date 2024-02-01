interface LocalStorage {
    fun lastLoaded(): String?
    fun onLoad(dir: String)
}