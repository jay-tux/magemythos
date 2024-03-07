import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.launch
import runtime.ChoiceScope
import runtime.ExecutionIterator
import runtime.Runtime
import runtime.ast.Value
import ui.CharacterCreationDialog
import ui.ChoiceDialog
import ui.Console
import ui.cacheLoader
import ui.loader
import ui.theme.MageMythosTheme

enum class BottomTab(val show: String) {
    NONE(""), CONSOLE("Console")
}

@Composable
fun mainView(cache: DesktopCache) = Surface {
    var bottomTab by remember { mutableStateOf(BottomTab.NONE) }
    val characters = cache.characters
    var selected by remember { mutableStateOf(-1) }
    var creationOpened by remember { mutableStateOf(false) }

    var requireChoice by remember { mutableStateOf(false) }
    var choiceName by remember { mutableStateOf("") }
    var choiceTitle by remember { mutableStateOf("") }
    var choiceCount by remember { mutableStateOf(0) }
    var choiceOptions by remember { mutableStateOf(listOf<Value>()) }
    var choicePost by remember { mutableStateOf({ _: List<Value> -> }) }

    var iterator by remember { mutableStateOf<ExecutionIterator?>(null) }

    Column(Modifier.padding(5.dp)) {
        Row(Modifier.weight(0.75f)) {
            Column(Modifier.weight(0.2f).background(MaterialTheme.colorScheme.secondaryContainer)) {
                Box(Modifier.weight(0.9f).fillMaxWidth()) {
                    if (characters.size == 0) {
                        Text("You have no characters yet.", Modifier.align(Alignment.Center))
                    } else {
                        LazyColumn {
                            items(characters.size) {
                                Button(
                                    { selected = it },
                                    Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                                    ),
                                    shape = MaterialTheme.shapes.extraSmall
                                ) {
                                    // TODO
                                }
                            }
                        }
                    }
                }
                Button(
                    { creationOpened = true },
                    Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(0.9f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                    ),
                    shape = MaterialTheme.shapes.extraSmall
                ) {
                    Text("Create Character")
                }
            }
            Box(Modifier.weight(0.8f).fillMaxHeight()) {
                if(selected != -1 && selected < characters.size) {
                    // TODO
                }
                else {
                    Text("Select a character to view their details.", Modifier.align(Alignment.Center))
                }
            }
        }
        Spacer(Modifier.height(5.dp))

        if (bottomTab != BottomTab.NONE) {
            when(bottomTab) {
                BottomTab.NONE -> {}
                BottomTab.CONSOLE -> Row(Modifier.weight(0.25f)) { Console(cache) }
            }
            Spacer(Modifier.height(5.dp))
        }
        Row(Modifier.height(50.dp).background(MaterialTheme.colorScheme.primaryContainer)) {
            LazyRow(Modifier.weight(0.9f).padding(5.dp)) {
                BottomTab.entries.forEach {
                    if (it != BottomTab.NONE) {
                        item {
                            Button(
                                { bottomTab = if (bottomTab == it) BottomTab.NONE else it },
                                Modifier.fillMaxHeight(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (bottomTab == it) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.primaryContainer,
                                    contentColor = if (bottomTab == it) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.onPrimaryContainer
                                ),
                                shape = MaterialTheme.shapes.small
                            ) {
                                Text(it.show)
                            }
                            Spacer(Modifier.width(5.dp))
                        }
                    }
                }
            }
            Box {
                Row(Modifier.padding(5.dp)) {
                    loader(cache)
                    Spacer(Modifier.width(5.dp))
                    cacheLoader(cache)
                }
            }
        }
    }

    if(creationOpened) {
        CharacterCreationDialog({ creationOpened = false }, { creationOpened = false }) {
            val scope = object : ChoiceScope {
                override fun invoke(
                    name: String,
                    title: String,
                    count: Int,
                    options: List<Value>,
                    post: (List<Value>) -> Unit
                ) {
                    requireChoice = true
                    choiceName = name
                    choiceTitle = title
                    choiceCount = count
                    choiceOptions = options
                    choicePost = post
                }
            }
            iterator = it(scope).also { iter ->
                while (!requireChoice && !iter.hasFinished()) iter.step()
            }
        }
    }

    if(requireChoice) {
        ChoiceDialog(choiceTitle, choiceOptions, choiceCount) {
            choicePost(it)
            requireChoice = false

            iterator?.let { iter ->
                while(!iter.hasFinished() && !requireChoice) iter.step()
            }
        }
    }
}

fun main() = application {
    val cache = DesktopCache()
    Runtime.initialize(cache, cache)
    Window(onCloseRequest = ::exitApplication, title = "MageMythos") {
        MageMythosTheme(true) {
            val scope = rememberCoroutineScope()
            scope.launch {
                loadCharacters(cache.characterCache(), cache, cache)
            }
            mainView(cache)
        }
    }
}
