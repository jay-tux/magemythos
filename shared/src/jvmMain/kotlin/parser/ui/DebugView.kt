package parser.ui

import Library
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
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
fun DebugView(tree: Library) = Row {
    Column(Modifier.weight(0.5f)) {
        Text("Types in (joined) AST (resolved files: ${tree.resolved.joinToString(", ")}):")
        Text(" -> Sources: ${tree.sources.joinToString(", ")}")
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
            Selection.CLASS -> classView(tree.classes.values)
            Selection.SUBCLASS -> subclassView(tree.subClasses.values)
            Selection.RACE -> raceView(tree.races.values)
            Selection.SUBRACE -> subRaceView(tree.subRaces.values)
            Selection.ITEM -> itemView(tree.items.values)
            Selection.SPELL -> spellView(tree.spells.values)
            Selection.BACKGROUND -> backgroundView(tree.backgrounds.values)
            Selection.ABILITY -> abilityView(tree.abilities.values)
            Selection.SKILL -> skillView(tree.skills.values)
        }
    }
}

@Composable
fun classView(classes: Collection<ClassDeclaration>) {
    LazyColumn {
        items(classes.toList()) {
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
fun subclassView(subClasses: Collection<SubClassDeclaration>) {
    LazyColumn {
        items(subClasses.toList()) {
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
fun raceView(races: Collection<RaceDeclaration>) {
    LazyColumn {
        items(races.toList()) {
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
fun subRaceView(subClasses: Collection<SubRaceDeclaration>) {
    LazyColumn {
        items(subClasses.toList()) {
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
fun itemView(items: Collection<ItemDeclaration>) {
    LazyColumn {
        items(items.toList()) {
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
fun spellView(spells: Collection<SpellDeclaration>) {
    LazyColumn {
        items(spells.toList()) {
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
fun backgroundView(backgrounds: Collection<BackgroundDeclaration>) {
    LazyColumn {
        items(backgrounds.toList()) {
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
fun abilityView(abilities: Collection<AbilityDeclaration>) {
    LazyColumn {
        items(abilities.toList()) {
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
fun skillView(skills: Collection<SkillDeclaration>) {
    LazyColumn {
        items(skills.toList()) {
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