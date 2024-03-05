import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.darkrockstudios.libraries.mpfilepicker.DirectoryPicker
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import runtime.ICache
import runtime.Runtime
import runtime.RuntimeError
import runtime.ast.Ast
import runtime.ast.AstBuilder
import runtime.ast.AstError
import runtime.ast.Provider
import runtime.ast.Streams
import java.io.File

@Composable
fun App(local: LocalStorage, cache: ICache, logger: ILogger) {
    MaterialTheme {
        var dialog by remember { mutableStateOf(false) }
        var ast by remember { mutableStateOf<Ast?>(null) }
        var error by remember { mutableStateOf<Exception?>(null) }
        var path by remember { mutableStateOf("") }

        val runLoad = {
            val base = path.split('/').dropLast(2).joinToString("/")
            try {
                AstBuilder.loadWithDeps(
                    source = path.split('/').dropLast(1).last(),
                    file = path.split('/').last().split('.')[0]
                ) { src, file ->
                    println("[Provider]: $src($file) -> $base/$src/$file.mm")
                    Streams(
                        File("$base/$src/$file.mm").inputStream(),
                        File("$base/$src/$file.mmstr").inputStream()
                    )
                }
            }
            catch (e: Exception) {
                error = e
                println(e)
                e.printStackTrace()
            }
        }

        Column {
            Box(Modifier.weight(0.1f).fillMaxWidth()) {
                LazyColumn(Modifier.align(Alignment.Center)) {
                    item {
                        Column {
                            Button(
                                { dialog = true },
                                Modifier.align(Alignment.CenterHorizontally)
                            ) {
                                Text("Load MM file")
                            }
                        }
                    }

                    error?.let {
                        item {
                            Text(it.javaClass.simpleName, color = MaterialTheme.colors.error)
                        }

                        item {
                            Text(it.message ?: "Unknown error", color = MaterialTheme.colors.error)
                        }
                        item {
                            if(it !is AstError && it !is RuntimeError) {
                                Text(it.stackTraceToString())
                            }
                        }
                        item {
                            Button({ runLoad() }) {
                                Text("Reload")
                            }
                        }
                    }
                }
            }
        }

        FilePicker(dialog, initialDirectory = local.lastLoaded(), fileExtensions = listOf("mm")) {
            dialog = false
            it?.let {
                ast = null
                local.onLoad(it.path)
                path = it.path
                runLoad()
            }
        }
    }
}