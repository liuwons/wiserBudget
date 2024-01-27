package com.lwons.wiserbudget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lwons.wiserbudget.TAB_DETAIL
import com.lwons.wiserbudget.Tab
import com.lwons.wiserbudget.tabs


@Composable
fun Toolbar(modifier: Modifier = Modifier, selectedTab: Tab = TAB_DETAIL, tabChangeListener: (Tab) -> Unit) {

    NavigationBar(modifier = modifier) {

        for (tab in tabs) {
            NavigationBarItem(
                icon = {
                    Image(painter = painterResource(tab.icon), "", modifier = Modifier.size(28.dp), contentScale = ContentScale.Inside)
                },
                label = {
                    Text(
                        text = tab.title, style = MaterialTheme.typography.bodySmall,
                    )
                },
                selected = tab == selectedTab,
                onClick = { tabChangeListener(tab) }
            )
        }
    }

}