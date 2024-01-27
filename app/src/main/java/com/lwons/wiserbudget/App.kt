package com.lwons.wiserbudget

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.lwons.wiserbudget.ui.theme.WiserTheme
import com.lwons.wiserbudget.screens.AuthenticateScreen
import com.lwons.wiserbudget.screens.LoadingScreen
import com.lwons.wiserbudget.screens.home.HomeScreen

@Composable
fun App() {
    WiserTheme {
        var loaded by remember { mutableStateOf(false) }
        var authenticated by remember { mutableStateOf(false) }

        if (authenticated) {
            HomeScreen(Modifier.background(MaterialTheme.colorScheme.background))
        } else if (loaded) {
            AuthenticateScreen { authenticated = true }
        } else {
            LoadingScreen { loaded = true }
        }
    }
}