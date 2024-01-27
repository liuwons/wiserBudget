package com.lwons.wiserbudget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class Category(val id: Int, val name: String, val icon: Int)

@Composable
fun CategoryItem(selected: Boolean, category: Category, onClick: (Category) -> Unit) {
    Column(modifier = Modifier.padding(top = 24.dp).clickable(interactionSource = remember { MutableInteractionSource() },
        indication = null) { onClick(category) }, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.size(60.dp)
            .clip(CircleShape)
            .background(if (selected) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.surfaceVariant)) {
            Icon(painter = painterResource(category.icon),
                contentDescription = category.name,
                tint = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))
        Text(category.name, style = MaterialTheme.typography.bodyMedium)
    }
}


object Categories {
    val expenseCategories by lazy {
        loadExpenseCategories()
    }

    val incomeCategories by lazy {
        loadIncomeCategories()
    }

    private fun loadExpenseCategories(): List<Category> {
        return listOf(
            Category(0, "House", R.drawable.house),
            Category(1, "Fitment", R.drawable.fitment),
            Category(2, "Travel", R.drawable.hotel),
            Category(3, "Liquor", R.drawable.liquor),
            Category(4, "Medical", R.drawable.medical_services),
            Category(5, "Digital", R.drawable.phone_iphone),
            Category(6, "Education", R.drawable.school),
            Category(7, "Shopping", R.drawable.shopping_cart),
            Category(8, "Sports", R.drawable.sports_tennis),
            Category(9, "Traffic", R.drawable.taxi),
            Category(10, "Toys", R.drawable.toys)
        )
    }

    private fun loadIncomeCategories(): List<Category> {
        return listOf(
            Category(1000, "Stock", R.drawable.stock),
        )
    }
}