package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import runtime.Character

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
fun nameDescButton(name: String, desc: String, selected: Boolean = false, modifier: Modifier = Modifier, onClick: () -> Unit) {
    var isOpen by remember { mutableStateOf(selected) }
    Surface(
        Modifier.fillMaxWidth().clickable { isOpen = !isOpen },
        shape = MaterialTheme.shapes.large,
        color = if(selected) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.background
    ) {
        Column {
            Row {
                Icon(
                    if (isOpen) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowRight,
                    ""
                )
                Spacer(Modifier.width(3.dp))
                Text(name, style = MaterialTheme.typography.bodyLarge, maxLines = 1)
            }
            if (isOpen) {
                Row {
                    Spacer(Modifier.width(10.dp))
                    Text(desc, style = MaterialTheme.typography.bodySmall)
                }

                Button(
                    onClick,
                    Modifier.fillMaxWidth(0.8f).align(Alignment.CenterHorizontally),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text("Select $name")
                }
            }
        }
    }
}

@Composable
fun CharacterWidget(char: Character, selected: Boolean, onClick: () -> Unit) {
    val name by char.name
    val race by char.race
    val subrace by char.subrace
    val classes by char.clazz

    Surface(
        Modifier.clickable { onClick() },
        color = if(selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column {
            Text(name, style = MaterialTheme.typography.bodyLarge)
            Text("Level ${classes.sumOf { it.level }} ${subrace?.displayName ?: race.displayName}", style = MaterialTheme.typography.bodySmall)
        }
    }
}