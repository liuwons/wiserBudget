package com.lwons.wiserbudget.screens.home.pages.append

import com.lwons.wiserbudget.Categories
import com.lwons.wiserbudget.Category
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.lwons.wiserbudget.screens.home.pages.append.TitleItem.CANCEL
import com.lwons.wiserbudget.screens.home.pages.append.TitleItem.EXPENSE
import com.lwons.wiserbudget.screens.home.pages.append.TitleItem.INCOME


const val TAB_EXPENSE = 0
const val TAB_INCOME = 1

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppendExpensePage(modifier: Modifier = Modifier, onDismiss: () -> Unit, onResult: (Int, Category, Float) -> Unit) {

    var pagerStatus = rememberPagerState(pageCount = { 2 })

    Column(modifier = modifier) {
        val coroutineScope = rememberCoroutineScope()

        Title(selectedIndex = pagerStatus.currentPage, modifier = Modifier.height(36.dp)) { clickedItem ->
            when (clickedItem) {
                INCOME -> {
                    coroutineScope.launch { pagerStatus.animateScrollToPage(TAB_EXPENSE) }
                }
                EXPENSE -> {
                    coroutineScope.launch { pagerStatus.animateScrollToPage(TAB_INCOME) }

                }
                else -> {
                    onDismiss()
                }
            }
        }

        HorizontalPager(state = pagerStatus, modifier = modifier.fillMaxSize()) {page ->
            if (page == TAB_EXPENSE) {
                AppendDetailTab(categories = Categories.expenseCategories, onDismiss = { onDismiss() }) { category, amount ->
                    onResult(TAB_EXPENSE, category, amount)
                    onDismiss()
                }
            } else {
                AppendDetailTab(categories = Categories.incomeCategories, onDismiss = { onDismiss() }) { category, amount ->
                    onResult(TAB_INCOME, category, amount)
                    onDismiss()
                }
            }
        }

    }

}

enum class TitleItem {
    INCOME,
    EXPENSE,
    CANCEL
}

@Composable
fun Title(selectedIndex: Int, modifier: Modifier = Modifier, onClick: (TitleItem) -> Unit) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Spacer(Modifier.width(100.dp))
        Row(Modifier.weight(1f)) {
            Text("Income",
                modifier = Modifier.weight(1f).clickable { onClick(INCOME) },
                textAlign = TextAlign.Right,
                fontWeight = if (selectedIndex == 0) FontWeight.Bold else FontWeight.Light
            )
            Spacer(Modifier.width(12.dp))
            Text("Expense",
                modifier = Modifier.weight(1f).clickable { onClick(EXPENSE) },
                textAlign = TextAlign.Left,
                fontWeight = if (selectedIndex == 1) FontWeight.Bold else FontWeight.Light
            )
        }
        Text("Cancel", Modifier.width(100.dp).clickable { onClick(CANCEL) }, textAlign = TextAlign.Center)
    }
}

