package com.lwons.wiserbudget.screens.home.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lwons.wiserbudget.log.Logger

@Composable
fun MoneyInput(modifier: Modifier = Modifier, onResult: (Float) -> Unit) {
    var hint by remember { mutableStateOf("") }
    var showSystemKeyboard by remember { mutableStateOf(false) }
    var currentInput by remember { mutableStateOf("0.0") }

    Column(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        Text(text = currentInput, style = MaterialTheme.typography.titleLarge, modifier = Modifier.fillMaxWidth().padding(20.dp), textAlign = TextAlign.Right)
        Row(modifier = Modifier.height(48.dp)
            .padding(horizontal = 12.dp)
            .background(color = MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Note:", modifier = Modifier.padding(end = 8.dp), style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
            BasicTextField(value = hint,
                onValueChange = { hint = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onBackground),
                singleLine = true,
                cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground))
        }
        Spacer(modifier = Modifier.height(12.dp).fillMaxWidth())
        if (!showSystemKeyboard) {
            Keyboard {
                currentInput = processInput(currentInput, it)
            }
        }
    }
}

private fun processInput(input: String, key: KeyboardKey): String {
    Logger.i("input", "processInput: $input, $key")
    return input + key.getStr()
}
