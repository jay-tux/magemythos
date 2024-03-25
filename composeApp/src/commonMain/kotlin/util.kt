import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State

fun <T> MutableList<T>.immutable(): List<T> = this
fun <K, V> MutableMap<K, V>.immutable(): Map<K, V> = this
fun <T> MutableState<T>.immutable(): State<T> = this

interface ImmutableRef<T> {
    fun get(): T

    companion object {
        fun <T> T.makeImmutableRef(): ImmutableRef<T> = object : ImmutableRef<T> {
            private val value: T = this@makeImmutableRef
            override fun get(): T = value
        }
    }
}

interface Ref<T> : ImmutableRef<T> {
    fun set(value: T)

    companion object {
        fun <T> T.makeRef(): Ref<T> = object : Ref<T> {
            private var value: T = this@makeRef
            override fun get(): T = value
            override fun set(value: T) {
                this.value = value
            }
        }
    }
}

fun Int.toSignedString() = if (this >= 0) "+$this" else this.toString()