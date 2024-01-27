package com.lwons.wiserbudget.screens.home.pages.append

import com.lwons.wiserbudget.Category
import com.lwons.wiserbudget.CategoryItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells.Adaptive
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lwons.wiserbudget.screens.home.pages.MoneyInput


@Composable
fun AppendDetailTab(categories: List<Category>, modifier: Modifier = Modifier, onDismiss: () -> Unit, appendResult: (Category, Float) -> Unit) {
    var currentCategory by remember { mutableStateOf<Category?>(null) }
    var showKeyboard by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize()) {
        Box(modifier = modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp)) {
            LazyVerticalGrid(columns = Adaptive(minSize = 80.dp)) {
                items(categories.size) { idx ->
                    categories[idx].let { category ->
                        CategoryItem(selected = currentCategory == category, category = category) {
                            currentCategory = category
                            showKeyboard = true
                        }
                    }
                }
            }

            if (showKeyboard) {
                MoneyInput(modifier = modifier.align(Alignment.BottomCenter).fillMaxWidth()) { result ->
                    showKeyboard = false

                    currentCategory?.let { category ->
                        appendResult(category, result)
                    } ?: run {
                        onDismiss()
                    }
                }
            }
        }
    }
}