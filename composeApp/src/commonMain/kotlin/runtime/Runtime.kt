package runtime

import ILogger

object Runtime {
    class UninitializedException(what: String) : Exception("Runtime is not initialized (missing: $what)")

    private lateinit var logger: ILogger
    private lateinit var cache: ICache

    fun initialize(logger: ILogger, cache: ICache) {
        if(!::logger.isInitialized) this.logger = logger
        if(!::cache.isInitialized) this.cache = cache
    }

    fun getCache(): ICache = if(::cache.isInitialized) cache else throw UninitializedException("cache")
    fun getLogger(): ILogger = if(::logger.isInitialized) logger else throw UninitializedException("logger")
}