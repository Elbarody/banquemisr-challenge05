package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoriesPageTabs(tabsList: List<String>, selectedIndex: Int, onTabSelected: (Int) -> Unit) {
    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        divider = {},
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(size = 12.dp)
            ),
        indicator = {}
    ) {
        tabsList.forEachIndexed { index, textString ->
            val selected = selectedIndex == index
            Tab(modifier = Modifier
                .background(
                    if (selected) Color.White
                    else Color.Transparent,
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(shape = RoundedCornerShape(12.dp)),
                onClick = {
                    onTabSelected(index)
                },
                selectedContentColor = Color.Transparent,
                selected = selected,
                text = {
                    TabTextView(selected, textString)
                })
        }
    }
}