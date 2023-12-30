import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import parser.ast.DeclarationSet
import parser.ast.notLast
import parser.ui.DebugView

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(cache: Cache) {
    MaterialTheme {
        var showPicker by remember { mutableStateOf(false) }
        var lib by remember { mutableStateOf(Library.empty()) }
        var error by remember { mutableStateOf<Exception?>(null) }

        Column {
            Box(Modifier.weight(0.8f)) {
                    DebugView(lib)
            }

            Box(Modifier.weight(0.2f).fillMaxSize()) {
                Column(Modifier.align(Alignment.Center)) {
                    Button({ showPicker = true }) {
                        Text("Load *.mm file")
                    }
                    Button({ lib = Library.empty() }) {
                        Text("Reset library")
                    }
                }
            }
        }

        error?.let {
            AlertDialog(
                { lib = Library.empty(); error = null },
                buttons = @Composable {
                    Column(Modifier.fillMaxWidth()){
                        Button({ lib = Library.empty(); error = null }) { Text("OK") }
                    }
                },
                title = @Composable {
                    Column(Modifier.fillMaxWidth()){
                        Text("Parsing error", Modifier.align(Alignment.CenterHorizontally))
                    }
                },
                text = @Composable {
                    Column {
                        var opened by remember { mutableStateOf(false) }
                        Text(it.message ?: "(Unknown error)")
                        Text(" -> ${it::class.simpleName}")
                        it.cause?.let {
                            Text(" -> Caused by ${it::class.simpleName} (${it.message ?: "(???)"})")
                        }

                        Row(Modifier.clickable { opened = !opened }) {
                            Icon(
                                if(opened) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowRight,
                                ""
                            )
                            Text("Stack trace")
                        }
                        if(opened) {
                            LazyColumn {
                                items(it.stackTrace.toList()) { e ->
                                    Text(e.toString())
                                }
                            }
                        }
                    }
                }
            )
        }

        FilePicker(showPicker, initialDirectory = cache.lastDir(), fileExtensions = listOf("mm")) {
            it?.let { f ->
                showPicker = false
                cache.updateLastDir(f.path.split('/').notLast().joinToString("/"))
                try {
                    lib = Library.loadInto(f.path, lib)
                    lib.verify()
                }
                catch (e: Exception) {
                    lib = Library.empty()
                    error = e
                }
            }
        }
    }
}