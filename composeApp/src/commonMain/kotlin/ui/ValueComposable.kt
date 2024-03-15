package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import runtime.ast.BoolValue
import runtime.ast.CurrencyValue
import runtime.ast.DiceValue
import runtime.ast.FloatValue
import runtime.ast.IntValue
import runtime.ast.ListValue
import runtime.ast.ObjectValue
import runtime.ast.RangeValue
import runtime.ast.RollValue
import runtime.ast.StringValue
import runtime.ast.Value
import runtime.ast.VoidValue

@Composable
fun Value.render(modifier: Modifier = Modifier): Unit = when(this) {
    is BoolValue -> Text("$value", modifier)
    is CurrencyValue -> Text("$amount$unit", modifier)
    is DiceValue -> Text(toString(), modifier)
    is FloatValue -> Text("$value", modifier)
    is IntValue -> Text("$value", modifier)
    is ListValue -> Column(modifier) {
        value.forEach { it.render() }
    }
    is ObjectValue -> Column(modifier) {
        Text(type.displayName, style = MaterialTheme.typography.bodyLarge)
        Text(type.description, style = MaterialTheme.typography.bodySmall)
    }
    is RangeValue -> Text("$start until $endIncl (inclusive)", modifier)
    is RollValue -> Text("${count}d$kind")
    is StringValue -> Text(value, modifier)
    is VoidValue -> Text("(nothing/void)", modifier)
}