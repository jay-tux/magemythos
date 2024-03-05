fun <T> MutableList<T>.immutable(): List<T> = this
fun <K, V> MutableMap<K, V>.immutable(): Map<K, V> = this