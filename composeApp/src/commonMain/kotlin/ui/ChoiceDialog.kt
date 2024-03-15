package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import runtime.ast.Value
import java.awt.Dimension
import java.awt.GraphicsEnvironment

fun screenSize(): Dimension =
    GraphicsEnvironment.getLocalGraphicsEnvironment().maximumWindowBounds.size

fun screenWidth() = screenSize().width
fun screenHeight() = screenSize().height

@Composable
fun ChoiceDialog(
    title: String,
    options: List<Value>,
    count: Int,
    width: Dp = (screenWidth() / 3).dp,
    height: Dp = (screenHeight() * 4 / 5).dp,
    onChoiceMade: (List<Value>) -> Unit
) {
    if (count == 1)
        ChoiceDialogSingle(title, options, width, height, onChoiceMade)
    else
        ChoiceDialogMultiple(title, options, count, width, height, onChoiceMade)
}

@Composable
fun ChoiceDialogMultiple(
    title: String,
    options: List<Value>,
    count: Int,
    width: Dp = (screenWidth() / 3).dp,
    height: Dp = (screenHeight() * 4 / 5).dp,
    onChoiceMade: (List<Value>) -> Unit
) {
    var selected by remember { mutableStateOf(listOf<Int>()) }

    val onSelect = { it: Int ->
        selected = if (selected.contains(it)) {
            selected.filter { i -> i != it }
        } else if (selected.size < count) {
            selected + it
        } else {
            selected.drop(1) + it
        }
    }

    Dialog(
        {}, properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Surface(Modifier.width(width).height(height).padding(5.dp)) {
            Column {
                Text(title)
                Text("Pick $count options", style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.height(10.dp))
                LazyColumn(Modifier.weight(1f)) {
                    itemsIndexed(options) { idx, it ->
                        Row(Modifier.clickable { onSelect(idx) }) {
                            RadioButton(
                                selected.contains(idx),
                                onClick = { onSelect(idx) },
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Spacer(Modifier.width(5.dp))
                            it.render()
                        }
                    }
                }
                Button(
                    { onChoiceMade(selected.map { options[it] }) },
                    Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.8f),
                    enabled = selected.size == count
                ) {
                    Text("Confirm choices")
                }
                Spacer(Modifier.height(5.dp))
            }
        }
    }
}

@Composable
fun ChoiceDialogSingle(
    title: String,
    options: List<Value>,
    width: Dp = (screenWidth() / 3).dp,
    height: Dp = (screenHeight() * 4 / 5).dp,
    onChoiceMade: (List<Value>) -> Unit
) {
    var selected by remember { mutableStateOf(-1) }

    val onSelect = { idx: Int ->
        selected = if (idx == selected) -1 else idx
    }

    Dialog(
        {}, properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Surface(Modifier.width(width).height(height).padding(5.dp)) {
            Column {
                Text(title)
                Text("Pick one", style = MaterialTheme.typography.bodySmall)
                LazyColumn(Modifier.weight(1f)) {
                    itemsIndexed(options) { idx, it ->
                        Row(Modifier.clickable { onSelect(idx) }) {
                            RadioButton(
                                selected == idx,
                                onClick = { onSelect(idx) },
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Spacer(Modifier.width(5.dp))
                            it.render()
                        }
                    }
                }

                Button(
                    { onChoiceMade(listOf(options[selected])) },
                    Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.8f),
                    enabled = selected != -1
                ) {
                    Text("Confirm choice")
                }
                Spacer(Modifier.height(5.dp))
            }
        }
    }
}













