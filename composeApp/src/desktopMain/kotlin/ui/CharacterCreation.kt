package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import runtime.Background
import runtime.Class
import runtime.Race
import runtime.Runtime
import runtime.Subrace
import runtime.Type
import runtime.Character
import runtime.ChoiceDesc
import runtime.ChoiceScope
import runtime.ast.ListValue
import runtime.subracesFor
import runtime.typesOfKind
import java.awt.GraphicsEnvironment
import kotlin.math.min

enum class CreationPage { MAIN, RACE, CLASS, BACKGROUND }

@Composable
fun CharacterCreationDialog(onExit: () -> Unit, onFinish: () -> Unit) {
    var name by remember { mutableStateOf("") }
    val raceOptions by remember { mutableStateOf(Runtime.getCache().typesOfKind<Race>()) }
    var subraceOptions by remember { mutableStateOf(listOf<Subrace>()) }
    val classOptions by remember { mutableStateOf(Runtime.getCache().typesOfKind<Class>()) }
    val backgroundOptions by remember { mutableStateOf(Runtime.getCache().typesOfKind<Background>()) }

    var raceIdx by remember { mutableStateOf(-1) }
    var subraceIdx by remember { mutableStateOf(-1) }
    var classIdx by remember { mutableStateOf(-1) }
    var backgroundIdx by remember { mutableStateOf(-1) }

    var page by remember { mutableStateOf(CreationPage.MAIN) }
    val screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().maximumWindowBounds.size

    val w = min((screenSize.width * 0.3f).toInt(), 500).dp
    val h = min((screenSize.height * 0.8f).toInt(), 800).dp

    var choice by remember { mutableStateOf<ChoiceDesc?>(null) }
    var builder by remember { mutableStateOf<Character.Companion.Builder?>(null) }

    val scope = rememberCoroutineScope()
    val runBuilder = {
        scope.launch {
            builder?.run { c -> choice = c }
        }
    }

    val startBuilder = {
        builder = Character.Companion.Builder(
            name,
            raceOptions[raceIdx],
            if(subraceIdx == -1) null else subraceOptions[subraceIdx],
            classOptions[classIdx],
            backgroundOptions[backgroundIdx]
        )
        runBuilder()
    }

    Dialog({ onFinish() }, properties = DialogProperties()) {
        Surface(Modifier.width(w).height(h).padding(5.dp).background(MaterialTheme.colorScheme.secondaryContainer)) {
            when (page) {
                CreationPage.MAIN -> CharacterMainPage(
                    name,
                    if(raceIdx == -1) null else raceOptions[raceIdx],
                    if(subraceIdx == -1) null else subraceOptions[subraceIdx],
                    if(classIdx == -1) null else classOptions[classIdx],
                    if(backgroundIdx == -1) null else backgroundOptions[backgroundIdx],
                    // name has to be set, class has to be set, race has to be set & if race has subraces: subrace has to be set
                    name.isNotEmpty() && classIdx != -1 && raceIdx != -1 && (!raceOptions[raceIdx].hasSubraces || subraceIdx != -1) && backgroundIdx != -1,
                    { name = it },
                    { page = CreationPage.RACE },
                    { page = CreationPage.CLASS },
                    { page = CreationPage.BACKGROUND },
                    onExit,
                    { startBuilder() }
                )

                CreationPage.RACE -> CharacterRacePage(
                    raceIdx,
                    subraceIdx,
                    raceOptions,
                    subraceOptions,
                    { page = CreationPage.MAIN },
                    { raceIdx = it; subraceIdx = -1; subraceOptions = Runtime.getCache().subracesFor(raceOptions[it]) },
                    { subraceIdx = it; page = CreationPage.MAIN }
                )

                CreationPage.CLASS -> CharacterClassPage(
                    classIdx,
                    classOptions,
                    { page = CreationPage.MAIN },
                    { classIdx = it; page = CreationPage.MAIN }
                )

                CreationPage.BACKGROUND -> CharacterBackgroundPage(
                    backgroundIdx,
                    backgroundOptions,
                    { page = CreationPage.MAIN },
                    { backgroundIdx = it; page = CreationPage.MAIN }
                )
            }
        }
    }

    choice?.let {
        ChoiceDialog(it.title, it.options, it.count) { c ->
            builder?.provideChoice(it.name, if(it.count == 1) c[0] else ListValue(c, c[0].pos))
            choice = null
            scope.launch { runBuilder() }
        }
    }
}

@Composable
fun CharacterMainPage(name: String, race: Race?, subrace: Subrace?, `class`: Class?, background: Background?, finished: Boolean, onDeltaName: (String) -> Unit, onRaceSelection: () -> Unit, onClassSelection: () -> Unit, onBackgroundSelection: () -> Unit, cancel: () -> Unit, finish: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        OutlinedTextField(
            name,
            onDeltaName,
            Modifier.fillMaxWidth(0.8f).align(Alignment.CenterHorizontally),
            label = { Text("Character Name") },
            singleLine = true
        )
        Spacer(Modifier.height(5.dp))
        Box(Modifier.fillMaxWidth(0.8f).align(Alignment.CenterHorizontally)) {
            Button(onRaceSelection, Modifier.fillMaxWidth()) {
                race?.let {
                    if (it.hasSubraces)
                        Text("${it.displayName} (${subrace?.displayName ?: "Select Subrace"})")
                    else
                        Text(it.displayName)
                } ?: Text("Select race")
            }
        }
        Spacer(Modifier.height(5.dp))
        Box(Modifier.fillMaxWidth(0.8f).align(Alignment.CenterHorizontally)) {
            Button(onClassSelection, Modifier.fillMaxWidth()) {
                `class`?.let { Text(it.displayName) } ?: Text("Select class")
            }
        }
        Spacer(Modifier.height(5.dp))
        Box(Modifier.fillMaxWidth(0.8f).align(Alignment.CenterHorizontally)) {
            Button(onBackgroundSelection, Modifier.fillMaxWidth()) {
                background?.let { Text(it.displayName) } ?: Text("Select background")
            }
        }
        Spacer(Modifier.weight(1f))
        Row(Modifier.fillMaxWidth(0.8f).align(Alignment.CenterHorizontally)) {
            Button(cancel, Modifier.weight(0.5f)) { Text("Cancel") }
            Spacer(Modifier.width(5.dp))
            Button(finish, Modifier.weight(0.5f), enabled = finished) { Text("Finalize") }
        }
    }
}

@Composable
fun <T: Type> SelectionList(header: String, selected: Int, options: List<T>, cancelText: String, onCancel: () -> Unit, onPick: (Int) -> Unit) = Column {
    Text(header)
    LazyColumn(Modifier.weight(1f).fillMaxWidth()) {
        itemsIndexed(options) { idx, it ->
            Box(Modifier.fillMaxWidth()) {
                nameDescButton(
                    it.displayName,
                    it.description,
                    selected == idx,
                    Modifier.fillMaxWidth(0.8f).align(Alignment.Center)
                ) {
                    onPick(idx)
                }
            }
            Spacer(Modifier.height(5.dp))
        }
    }
    Button(onCancel, Modifier.fillMaxWidth(0.8f).align(Alignment.CenterHorizontally)) {
        Text(cancelText)
    }
}

@Composable
fun CharacterRacePage(selectedRace: Int, selectedSubrace: Int, races: List<Race>, subraces: List<Subrace>, cancel: () -> Unit, onPickRace: (Int) -> Unit, onPickSubrace: (Int) -> Unit) = Column {
    var override by remember { mutableStateOf(false) }
    if(subraces.isNotEmpty() && !override) {
        SelectionList("Select a subrace for ${races[selectedRace].displayName}", selectedSubrace, subraces, "Back to race selection", { override = true }, onPickSubrace)
    }
    else {
        SelectionList("Select a character race", selectedRace, races, "Cancel race selection", cancel) {
            override = false
            onPickRace(it)
        }
    }
}

@Composable
fun CharacterClassPage(selectedClass: Int, classes: List<Class>, cancel: () -> Unit, onPickClass: (Int) -> Unit) =
    SelectionList("Select a character class", selectedClass, classes, "Cancel class selection", cancel, onPickClass)

@Composable
fun CharacterBackgroundPage(selectedBackground: Int, backgrounds: List<Background>, cancel: () -> Unit, onPickBackground: (Int) -> Unit) =
    SelectionList("Select a character background", selectedBackground, backgrounds, "Cancel background selection", cancel, onPickBackground)