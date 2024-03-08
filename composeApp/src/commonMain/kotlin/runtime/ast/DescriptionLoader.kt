package runtime.ast

class DescriptionLoader(private val input: String, private val src: String) {
    private val cache = mutableMapOf<String, String>()

    fun parse(): Map<String, String> {
        if(cache.isEmpty()) actualParse()
        return cache
    }

    private fun actualParse() {
        var idx = 0

        while(idx < input.length) {
            val nextSep = input.indexOf(':', idx)
            if(nextSep == -1) throw DescMissingColonError(src)
            var nextEnd = input.indexOf("\n\n", nextSep + 1)

            if(nextEnd == -1) {
                nextEnd = input.length - 1
            }
            cache[input.substring(idx, nextSep).trim()] = input.substring(nextSep + 1, nextEnd).trim()
            idx = nextEnd + 2
        }
    }
}