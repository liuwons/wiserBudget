package com.lwons.wiserbudget

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ActionButton(modifier: Modifier = Modifier, onClick: () -> Unit) {

    FloatingActionButton(onClick = onClick,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer) {

        Icon(imageVector = Icons.Outlined.Create, contentDescription = "Add")
    }
}