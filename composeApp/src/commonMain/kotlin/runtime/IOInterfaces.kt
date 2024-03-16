package runtime

import runtime.ast.Streams
import java.io.InputStream
import java.io.OutputStream

interface ILoader {
    suspend fun loadSource(source: String, file: String): Streams
    suspend fun loadSourceList(): InputStream
    suspend fun loadCharacterList(): InputStream
    suspend fun loadCharacter(name: String): InputStream
}

interface IStorage {
    suspend fun saveCharacterList(): OutputStream
    suspend fun saveCharacter(name: String): OutputStream
}