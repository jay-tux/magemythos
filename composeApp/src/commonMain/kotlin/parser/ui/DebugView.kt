package parser.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.onClick
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import parser.ast.AbilityDeclaration
import parser.ast.BackgroundDeclaration
import parser.ast.ClassDeclaration
import parser.ast.DeclarationSet
import parser.ast.ItemDeclaration
import parser.ast.RaceDeclaration
import parser.ast.SkillDeclaration
import parser.ast.SpellDeclaration
import parser.ast.SubClassDeclaration
import parser.ast.SubRaceDeclaration

enum class Selection(val disp: String) {
    CLASS("Classes"), SUBCLASS("Sub-classes"),
    RACE("Races"), SUBRACE("Sub-races"),
    ITEM("Items"), SPELL("Spells"),
    BACKGROUND("Backgrounds"), ABILITY("Abilities"),
    SKILL("Skills")
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DebugView(strings: Map<String, String>, tree: DeclarationSet) = Row {
    Column(Modifier.weight(0.5f)) {
        Text("Strings from all string files:")
        LazyColumn(Modifier.weight(0.33f)) {
            items(strings.entries.toList()) {
                var opened by remember { mutableStateOf(false) }
                Column {
                    Row(Modifier.onClick { opened = !opened }) {
                        Icon(
                            if (opened) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowRight,
                            ""
                        )
                        Text(it.key)
                    }

                    if (opened) {
                        Row {
                            Spacer(Modifier.width(10.dp))
                            Text(it.value)
                        }
                    }
                }
            }
        }
    }

    Column(Modifier.weight(0.5f)) {
        Text("Types in AST (source: ${tree.source}, dependencies: ${tree.deps.joinToString(", ")}):")
        var current by remember { mutableStateOf(Selection.CLASS) }
        LazyRow {
            items(Selection.entries) {
                Button({current = it}, enabled = current != it) {
                    Text(it.disp)
                }
                Spacer(Modifier.width(10.dp))
            }
        }

        when(current) {
            Selection.CLASS -> classView(tree.classes)
            Selection.SUBCLASS -> subclassView(tree.subClasses)
            Selection.RACE -> raceView(tree.races)
            Selection.SUBRACE -> subRaceView(tree.subRaces)
            Selection.ITEM -> itemView(tree.items)
            Selection.SPELL -> spellView(tree.spells)
            Selection.BACKGROUND -> backgroundView(tree.backgrounds)
            Selection.ABILITY -> abilityView(tree.abilities)
            Selection.SKILL -> skillView(tree.skills)
        }
    }
}

@Composable
fun classView(classes: List<ClassDeclaration>) {
    LazyColumn {
        items(classes) {
            Text("Class: ${it.name} (${it.displayName})")
            Row {
                Spacer(Modifier.width(10.dp))
                Text(it.description)
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Declared at: ${it.pos}")
            }
        }
    }
}

@Composable
fun subclassView(subClasses: List<SubClassDeclaration>) {
    LazyColumn {
        items(subClasses) {
            Text("Sub-class: ${it.name} (${it.displayName})")
            Row {
                Spacer(Modifier.width(10.dp))
                Text(it.description)
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Sub-class for: ${it.subFor}")
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Declared at: ${it.pos}")
            }
        }
    }
}

@Composable
fun raceView(races: List<RaceDeclaration>) {
    LazyColumn {
        items(races) {
            Text("Race: ${it.name} (${it.displayName})")
            Row {
                Spacer(Modifier.width(10.dp))
                Text(it.description)
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Declared at: ${it.pos}")
            }
        }
    }
}

@Composable
fun subRaceView(subClasses: List<SubRaceDeclaration>) {
    LazyColumn {
        items(subClasses) {
            Text("Sub-race: ${it.name} (${it.displayName})")
            Row {
                Spacer(Modifier.width(10.dp))
                Text(it.description)
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Sub-race for: ${it.subFor}")
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Declared at: ${it.pos}")
            }
        }
    }
}

@Composable
fun itemView(items: List<ItemDeclaration>) {
    LazyColumn {
        items(items) {
            Text("Item: ${it.name} (${it.displayName})")
            Row {
                Spacer(Modifier.width(10.dp))
                Text(it.description)
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Declared at: ${it.pos}")
            }
        }
    }
}

@Composable
fun spellView(spells: List<SpellDeclaration>) {
    LazyColumn {
        items(spells) {
            Text("Spell: ${it.name} (${it.displayName})")
            Row {
                Spacer(Modifier.width(10.dp))
                Text(it.description)
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Declared at: ${it.pos}")
            }
        }
    }
}

@Composable
fun backgroundView(backgrounds: List<BackgroundDeclaration>) {
    LazyColumn {
        items(backgrounds) {
            Text("Background: ${it.name} (${it.displayName})")
            Row {
                Spacer(Modifier.width(10.dp))
                Text(it.description)
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Declared at: ${it.pos}")
            }
        }
    }
}

@Composable
fun abilityView(abilities: List<AbilityDeclaration>) {
    LazyColumn {
        items(abilities) {
            Text("Ability: ${it.name} (${it.displayName})")
            Row {
                Spacer(Modifier.width(10.dp))
                Text(it.description)
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Declared at: ${it.pos}")
            }
        }
    }
}

@Composable
fun skillView(skills: List<SkillDeclaration>) {
    LazyColumn {
        items(skills) {
            Text("Skill: ${it.name} (${it.displayName})")
            Row {
                Spacer(Modifier.width(10.dp))
                Text(it.description)
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Uses ability: ${it.dependsOn}")
            }
            Row {
                Spacer(Modifier.width(10.dp))
                Text("Declared at: ${it.pos}")
            }
        }
    }
}