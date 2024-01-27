package com.lwons.wiserbudget.screens.home

import com.lwons.wiserbudget.ActionButton
import com.lwons.wiserbudget.TAB_DETAIL
import com.lwons.wiserbudget.TAB_DISCOVER
import com.lwons.wiserbudget.TAB_GRAPH
import com.lwons.wiserbudget.Toolbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.lwons.wiserbudget.screens.home.pages.DetailPage
import com.lwons.wiserbudget.screens.home.pages.DiscoverPage
import com.lwons.wiserbudget.screens.home.pages.GraphicsPage
import com.lwons.wiserbudget.screens.home.pages.SettingsPage
import com.lwons.wiserbudget.screens.home.pages.append.AppendExpensePage

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var currentTab by remember { mutableStateOf(TAB_DETAIL) }
    var showAppend by remember { mutableStateOf(false) }

    Scaffold(modifier = modifier.fillMaxSize(),
        bottomBar = { Toolbar(modifier = modifier, selectedTab = currentTab, tabChangeListener = { currentTab = it }) },
        floatingActionButton = { ActionButton { showAppend = true } }) { padding ->

        Box {
            when (currentTab) {
                TAB_DETAIL -> {
                    DetailPage(modifier = modifier.padding(padding))
                }
                TAB_GRAPH -> {
                    GraphicsPage(modifier = modifier.padding(padding))
                }
                TAB_DISCOVER -> {
                    DiscoverPage(modifier = modifier.padding(padding))
                }
                else -> {
                    SettingsPage(modifier = modifier.padding(padding))
                }
            }

            if (showAppend) {
                AppendExpensePage(modifier = modifier.padding(padding), onDismiss = { showAppend = false }) { tab, name, amount ->
                    showAppend = false

                }
            }
        }
    }
}