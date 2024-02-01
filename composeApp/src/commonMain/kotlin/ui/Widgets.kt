package ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun indented(indent: Int, content: @Composable () -> Unit) = Row {
    Spacer(Modifier.width((indent * 10).dp))
    content()
}

@Composable
fun openClose(isOpen: Boolean, onToggle: (Boolean) -> Unit, content: @Composable () -> Unit) {
    IconButton(onClick = { onToggle(!isOpen) }) {
        Row {
            Icon(if (isOpen) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowForward, "")
            content()
        }
    }
}

@Composable
fun indentedOpenClose(
    indent: Int,
    isOpen: Boolean,
    onToggle: (Boolean) -> Unit,
    content: @Composable () -> Unit
) = indented(indent) {
    openClose(isOpen, onToggle, content)
}