package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import runtime.Character
import runtime.Runtime
import runtime.Skill
import runtime.typesOfKind
import toSignedString

@Composable
fun CharacterView(char: Character) {
    val name by char.name
    val race by char.race
    val subrace by char.subrace
    val classes by char.clazz
    val background by char.background
    val hp by char.hp
    val abilities by char.abilities
    val saves by char.saves
    val inventory by char.inventory
    val traits by char.traits
    val languages by char.languages
    val proficiencies by char.proficiencies
    val skillBonuses by char.skillBonuses
    val baseAc by char.baseAc
    val modAc by char.modAC
    val speed by char.speed
    val skills by remember { mutableStateOf(Runtime.getCache().typesOfKind<Skill>().sortedBy { it.displayName }) }
    val iProfs by char.itemProfs
    val itProfs by char.itemTypeProfs

    Column(Modifier.fillMaxSize().padding(5.dp)) {
        Row(Modifier.weight(0.1f)) {
            Text(name, Modifier.weight(0.33f), style = MaterialTheme.typography.headlineMedium)
            Column(Modifier.weight(0.33f)) {
                subrace?.let {
                    Text("${race.displayName} (${it.displayName})")
                } ?: Text(race.displayName)
                Text(background.displayName)
            }
            LazyColumn(Modifier.weight(0.33f)) {
                items(classes) { clazz ->
                    Text("${clazz.clazz.displayName} ${clazz.level}", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
        Row(Modifier.weight(0.9f)) {
            Column(Modifier.weight(0.25f)) {
                Row(Modifier.weight(0.75f)) {
                    LazyColumn(Modifier.weight(0.20f)) {
                        items(abilities.toList()) { (a, v) ->
                            Column {
                                AbilityWidget(a, v, Modifier.height(75.dp))
                                Spacer(Modifier.height(10.dp))
                            }
                        }
                    }
                    Column(Modifier.weight(0.80f)) {
                        Row {
                            RadioButton(false, {}, Modifier.weight(0.1f).size(20.dp))
                            Text("Inspiration", Modifier.weight(0.9f).align(Alignment.CenterVertically), fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.height(5.dp))
                        Row {
                            Box(Modifier.weight(0.1f)) {
                                Text("+0", Modifier.align(Alignment.Center)) // TODO: use actual proficiency
                            }
                            Text("Proficiency Bonus", Modifier.weight(0.9f).align(Alignment.CenterVertically), fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.height(5.dp))
                        LazyColumn(Modifier.weight(0.3f), verticalArrangement = Arrangement.spacedBy(0.dp)) {
                            item {
                                Box(Modifier.fillMaxWidth()) {
                                    Text("Saving Throws", Modifier.align(Alignment.Center), style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                                }
                            }
                            items(abilities.toList()) { (a, v) ->
                                Row {
                                    RadioButton(saves.contains(a), {}, Modifier.weight(0.1f).size(20.dp))
                                    Box(Modifier.weight(0.1f).align(Alignment.CenterVertically)) {
                                        Text(
                                            Character.abilityMod(v).toSignedString(),
                                            Modifier.align(Alignment.Center)
                                        ) // TODO: proficiency
                                    }
                                    Text(a.displayName, Modifier.weight(0.8f).align(Alignment.CenterVertically))
                                }
                            }
                        }
                        Spacer(Modifier.height(5.dp))
                        LazyColumn(Modifier.weight(0.7f)) {
                            item {
                                Box(Modifier.fillMaxWidth()) {
                                    Text("Skills", Modifier.align(Alignment.Center), style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                                }
                            }
                            items(skills) {
                                Row {
                                    RadioButton(false, {}, Modifier.weight(0.1f).size(20.dp))
                                    abilities[it.ability]?.let { base ->
                                        Box(Modifier.weight(0.1f).align(Alignment.CenterVertically)) {
                                            Text(Character.abilityMod(base).toSignedString(), Modifier.align(Alignment.Center)) // TODO: proficiency
                                        }
                                        Text("${it.displayName} (${it.ability.abbrev})", Modifier.weight(0.8f).align(Alignment.CenterVertically))
                                    } ?: Text("Missing ability ${it.ability.displayName} for skill ${it.displayName}", Modifier.weight(0.9f).align(Alignment.CenterVertically), color = MaterialTheme.colorScheme.error)
                                }
                            }
                        }
                    }
                }
                Row {
                    Box(Modifier.weight(0.1f)) {
                        Text("10", Modifier.align(Alignment.Center))
                    }
                    Text("Passive Wisdom (Perception)", Modifier.weight(0.9f), fontWeight = FontWeight.Bold)
                }
                Row(Modifier.weight(0.25f)) {
                    Column(Modifier.weight(0.5f)) {
                        Text("Languages", fontWeight = FontWeight.Bold)
                        Row {
                            Spacer(Modifier.width(10.dp))
                            LazyColumn {
                                items(languages) {
                                    Text(it.displayName, style = MaterialTheme.typography.bodyMedium)
                                }
                            }
                        }
                    }
                    Column(Modifier.weight(0.5f)) {
                        Text("Item Proficiencies", fontWeight = FontWeight.Bold)
                        Row {
                            Spacer(Modifier.width(10.dp))
                            LazyColumn {
                                items(itProfs) {
                                    Text(it.displayName, style = MaterialTheme.typography.bodyMedium)
                                }
                                items(iProfs) {
                                    Text(it.displayName, style = MaterialTheme.typography.bodyMedium)
                                }
                            }
                        }
                    }
                }
            }
            Column(Modifier.weight(0.75f)) {
                Row(Modifier.weight(0.25f)) {
                    Column(Modifier.weight(0.5f)) {
                        Box(Modifier.weight(0.5f).fillMaxWidth().clickable {  }) {
                            Text("Current Hit Points", fontStyle = FontStyle.Italic)
                            Row(Modifier.align(Alignment.Center)) {
                                Text(hp.first.toString(), style = MaterialTheme.typography.bodyLarge)
                                Text("/${hp.second}", style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                        Box(Modifier.weight(0.5f).fillMaxWidth().clickable {  }) {
                            Text("Temporary Hit Points", fontStyle = FontStyle.Italic)
                            Text("0", Modifier.align(Alignment.Center), style = MaterialTheme.typography.bodyLarge) // TODO actual temp hp
                        }
                    }
                    Column(Modifier.weight(0.5f)) {}
                }
                Box(Modifier.weight(0.75f)) {}
            }
        }
    }
}

























