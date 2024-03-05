package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import runtime.Background
import runtime.Class
import runtime.Race
import runtime.Subrace

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

@Composable
fun nameDescButton(name: String, desc: String, invert: Boolean = false, modifier: Modifier = Modifier, onClick: () -> Unit) {
    val colors = ButtonDefaults.buttonColors()
    val invertColors = ButtonDefaults.buttonColors(
        containerColor = contentColorFor(MaterialTheme.colorScheme.primary),
        contentColor = MaterialTheme.colorScheme.primary,
        disabledContainerColor = contentColorFor(MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.disabled)),
        disabledContentColor = MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.disabled)
    )

    Button(onClick, modifier, colors = if (invert) invertColors else colors, shape = MaterialTheme.shapes.large) {
        Column {
            Text(name, style = MaterialTheme.typography.bodyLarge)
            Row {
                Spacer(Modifier.width(5.dp))
                Text(desc, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}