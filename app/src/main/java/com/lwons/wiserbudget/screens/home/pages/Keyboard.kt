package com.lwons.wiserbudget.screens.home.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Keyboard(modifier: Modifier = Modifier, onClick: (KeyboardKey) -> Unit) {
    Column(modifier = modifier.height(320.dp)) {
        keyboardItems.forEachIndexed() { idx, rowItems ->
            Divider(color = MaterialTheme.colorScheme.outline, thickness = 0.5.dp)
            Row(modifier = Modifier.weight(1f)) {
                rowItems.forEachIndexed { idx, item ->
                    if (idx != 0) {
                        VerticalDivider(color = MaterialTheme.colorScheme.outline, thickness = 0.5.dp)
                    }
                    KeyboardCell(item.text, modifier = Modifier.weight(1f)) { onClick(item.key) }
                }
            }
        }
        Divider(color = MaterialTheme.colorScheme.outline, thickness = 0.5.dp)
    }
}

@Composable
fun KeyboardCell(txt: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Surface(modifier = modifier.background(MaterialTheme.colorScheme.background), onClick = onClick) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = txt, modifier = Modifier.align(Alignment.Center), color = MaterialTheme.colorScheme.onBackground, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun VerticalDivider(color: Color = Color.Gray, thickness: Dp = 1.dp) {
    Box(
        modifier = Modifier
            .width(thickness)
            .fillMaxHeight()
            .background(color)
    )
}

val keyboardItems: List<List<KeyboardItem>> by lazy {
    listOf(
        listOf(
            KeyboardItem(KeyboardKey.ONE, "1"),
            KeyboardItem(KeyboardKey.TWO, "2"),
            KeyboardItem(KeyboardKey.THREE, "3"),
            KeyboardItem(KeyboardKey.CALENDAR, "Today")
        ),
        listOf(
            KeyboardItem(KeyboardKey.FOUR, "4"),
            KeyboardItem(KeyboardKey.FIVE, "5"),
            KeyboardItem(KeyboardKey.SIX, "6"),
            KeyboardItem(KeyboardKey.PLUS, "+")
        ),
        listOf(
            KeyboardItem(KeyboardKey.SEVEN, "7"),
            KeyboardItem(KeyboardKey.EIGHT, "8"),
            KeyboardItem(KeyboardKey.NINE, "9"),
            KeyboardItem(KeyboardKey.MINUS, "-")
        ),
        listOf(
            KeyboardItem(KeyboardKey.DOT, "."),
            KeyboardItem(KeyboardKey.ZERO, "0"),
            KeyboardItem(KeyboardKey.DELETE, "DEL"),
            KeyboardItem(KeyboardKey.DONE, "DONE")
        )
    )
}


data class KeyboardItem(val key: KeyboardKey, val text: String)

enum class KeyboardKey {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    DOT,
    ZERO,
    DELETE,
    DONE,
    PLUS,
    MINUS,
    CALENDAR
}

fun KeyboardKey.isNumber(): Boolean {
    return this == KeyboardKey.ONE ||
            this == KeyboardKey.TWO ||
            this == KeyboardKey.THREE ||
            this == KeyboardKey.FOUR ||
            this == KeyboardKey.FIVE ||
            this == KeyboardKey.SIX ||
            this == KeyboardKey.SEVEN ||
            this == KeyboardKey.EIGHT ||
            this == KeyboardKey.NINE ||
            this == KeyboardKey.ZERO
}

fun KeyboardKey.isOperator(): Boolean {
    return this == KeyboardKey.PLUS ||
            this == KeyboardKey.MINUS
}

fun KeyboardKey.isDot(): Boolean {
    return this == KeyboardKey.DOT
}

fun KeyboardKey.value(): Int {
    return when (this) {
        KeyboardKey.ONE -> 1
        KeyboardKey.TWO -> 2
        KeyboardKey.THREE -> 3
        KeyboardKey.FOUR -> 4
        KeyboardKey.FIVE -> 5
        KeyboardKey.SIX -> 6
        KeyboardKey.SEVEN -> 7
        KeyboardKey.EIGHT -> 8
        KeyboardKey.NINE -> 9
        KeyboardKey.ZERO -> 0
        else -> throw IllegalArgumentException("Not a number")
    }
}


fun KeyboardKey.getStr(): String {
    return when (this) {
        KeyboardKey.ONE -> "1"
        KeyboardKey.TWO -> "2"
        KeyboardKey.THREE -> "3"
        KeyboardKey.FOUR -> "4"
        KeyboardKey.FIVE -> "5"
        KeyboardKey.SIX -> "6"
        KeyboardKey.SEVEN -> "7"
        KeyboardKey.EIGHT -> "8"
        KeyboardKey.NINE -> "9"
        KeyboardKey.ZERO -> "0"
        KeyboardKey.DOT -> "."
        KeyboardKey.DELETE -> "DEL"
        KeyboardKey.DONE -> "DONE"
        KeyboardKey.PLUS -> "+"
        KeyboardKey.MINUS -> "-"
        KeyboardKey.CALENDAR -> "Today"
    }
}
