import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import parser.ui.DebugView

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        var showPicker by remember { mutableStateOf(false) }
        var ast by remember { mutableStateOf<DeclarationSet?>(null) }
        var strings by remember { mutableStateOf(mapOf<String, String>()) }
        var error by remember { mutableStateOf<Exception?>(null) }

        Column {
            ast?.let {
                Box(Modifier.weight(0.8f)) {
                    DebugView(strings, it)
                }
            }

            Box(Modifier.weight(0.2f).fillMaxSize()) {
                Button({ showPicker = true }, Modifier.align(Alignment.Center)) {
                    Text("Load *.mm file")
                }
            }
        }

        error?.let {
            AlertDialog(
                { error = null },
                buttons = @Composable { Button({ error = null }) { Text("OK") } },
                title = @Composable { Text("Parsing error") },
                text = @Composable {
                    Column {
                        Text(it.message ?: "(Unknown error)")
                        Text(" -> ${it::class.simpleName}")
                        LazyColumn {
                            items(it.stackTrace.toList()) { e ->
                                Text(e.toString())
                            }
                        }
                    }
                }
            )
        }

        FilePicker(showPicker, fileExtensions = listOf("mm")) {
            it?.let { f ->
                showPicker = false
                try {
                    val intermediate = DataLoader.loadFrom(f.path)
                    strings = intermediate.first
                    ast = intermediate.second
                }
                catch (e: Exception) {
                    error = e
                }
            }
        }
    }
}