package ui

import DesktopCache
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.md_theme_dark_warning

@Composable
fun Console(cache: DesktopCache) {
    var enableInfo by remember { mutableStateOf(true) }
    var enableWarning by remember { mutableStateOf(true) }
    var enableError by remember { mutableStateOf(true) }

    val filterer = { base: List<DesktopCache.Message> ->
        var res = base
        if (!enableInfo) res = res.filter { it.type != DesktopCache.MessageType.INFO }
        if (!enableWarning) res = res.filter { it.type != DesktopCache.MessageType.WARNING }
        if (!enableError) res = res.filter { it.type != DesktopCache.MessageType.ERROR }
        res
    }

    val offColors = IconButtonColors(
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f),
        disabledContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
    )

    val onColors = IconButtonColors(
        contentColor = MaterialTheme.colorScheme.primaryContainer,
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        disabledContentColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
        disabledContainerColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f)
    )

    Row {
        LazyColumn(Modifier.weight(1f)) {
            items(filterer(cache.messages)) {
                Text(
                    it.message.replace("\t", "    "),
                    color = when (it.type) {
                        DesktopCache.MessageType.INFO -> MaterialTheme.colorScheme.onPrimaryContainer
                        DesktopCache.MessageType.ERROR -> MaterialTheme.colorScheme.error
                        DesktopCache.MessageType.WARNING -> md_theme_dark_warning
                    }
                )
            }
        }
        Column {
            IconButton({ enableInfo = !enableInfo }, colors = if(!enableInfo) offColors else onColors) {
                Icon(Icons.Default.Info, "")
            }
            Spacer(Modifier.height(5.dp))
            IconButton({ enableWarning = !enableWarning }, colors = if(!enableWarning) offColors else onColors) {
                Icon(Icons.Default.Warning, "")
            }
            Spacer(Modifier.height(5.dp))
            IconButton({ enableError = !enableError }, colors = if(!enableError) offColors else onColors) {
                Icon(Icons.Default.Error, "")
            }
            Spacer(Modifier.height(5.dp))
            IconButton({ cache.clearLog() }) {
                Icon(Icons.Default.Delete, "")
            }
        }
    }
}