package ui

import DesktopCache
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.theme.md_theme_dark_warning

@Composable
fun Console(cache: DesktopCache) = Column {
    LazyColumn(Modifier.fillMaxWidth()) {
        items(cache.messages) {
            Text(
                it.message.replace("\t", "    "),
                color = when(it.type) {
                    DesktopCache.MessageType.INFO -> MaterialTheme.colorScheme.onPrimaryContainer
                    DesktopCache.MessageType.ERROR -> MaterialTheme.colorScheme.error
                    DesktopCache.MessageType.WARNING -> md_theme_dark_warning
                }
            )
        }
    }
}