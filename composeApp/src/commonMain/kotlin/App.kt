import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import runtime.ast.Ast
import runtime.ast.AstBuilder
import runtime.ast.AstError
import java.io.File

@Composable
fun App(local: LocalStorage) {
    MaterialTheme {
        var dialog by remember { mutableStateOf(false) }
        var ast by remember { mutableStateOf<Ast?>(null) }
        var error by remember { mutableStateOf<AstError?>(null) }

        Column {
            ast?.let {
                Box(Modifier.weight(0.9f)) {
                    it.render()
                }
            }

            Box(Modifier.weight(0.1f).fillMaxWidth()) {
                Column(Modifier.align(Alignment.Center)) {
                    Button({ dialog = true }, Modifier.align(Alignment.CenterHorizontally)) {
                        Text("Load MM file")
                    }

                    error?.let {
                        Text("Syntax Error", color = MaterialTheme.colors.error)
                        Text(it.message ?: "Unknown error", color = MaterialTheme.colors.error)
                    }
                }
            }
        }

        FilePicker(dialog, initialDirectory = local.lastLoaded(), fileExtensions = listOf("mm")) {
            dialog = false
            it?.let {
                ast = null
                local.onLoad(it.path)
                try {
                    ast = AstBuilder.loadSingle("", "") { _, _ ->
                        File(it.path).inputStream()
                    }
                }
                catch (e: AstError) {
                    error = e
                }
            }
        }
    }
}