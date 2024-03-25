package runtime

import ILogger
import LocalStorage

object Runtime {
    class UninitializedException(what: String) : Exception("Runtime is not initialized (missing: $what)")

    private lateinit var logger: ILogger
    private lateinit var cache: ICache
    private lateinit var storage: IStorage

    fun initialize(logger: ILogger, cache: ICache, storage: IStorage) {
        if(!::logger.isInitialized) this.logger = logger
        if(!::cache.isInitialized) this.cache = cache
        if(!::storage.isInitialized) this.storage = storage
    }

    fun <T> initialize(all: T) where T: ILogger, T: ICache, T: IStorage = initialize(all, all, all)

    fun getCache(): ICache = if(::cache.isInitialized) cache else throw UninitializedException("cache")
    fun getLogger(): ILogger = if(::logger.isInitialized) logger else throw UninitializedException("logger")
    fun getStorage(): IStorage = if(::storage.isInitialized) storage else throw UninitializedException("storage")
}