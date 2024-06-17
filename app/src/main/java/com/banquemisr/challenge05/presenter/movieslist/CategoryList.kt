package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoryList(
    categories: List<String>,
    onCategorySelected: (String) -> Unit
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .selectableGroup(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        itemsIndexed(categories) { index, item ->
            CategoryItem(
                category = item,
                index = index,
                selectedIndex = selectedIndex,
                onItemClicked = { clickedIndex ->
                    selectedIndex = clickedIndex
                    onCategorySelected(categories[clickedIndex])
                }
            )
        }
    }
}


@Composable
@Preview
fun CategoryListPreview() {
    CategoryList(categories = listOf("Category 1", "Category 2", "Category 3"), {})
}