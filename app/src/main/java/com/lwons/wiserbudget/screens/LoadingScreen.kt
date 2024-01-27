package com.lwons.wiserbudget.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingScreen(modifier: Modifier = Modifier, callback: () -> Unit) {
    Button(onClick = { callback() }, content = {
        Text("to authenticate")
    })
}