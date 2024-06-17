package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoriesTabLayout(content: @Composable (Int) -> Unit) {

    val list = listOf("categories", "categories 2", "categories 3")

    val pagerState = rememberPagerState(pageCount = { list.size })

    val coroutineScope = rememberCoroutineScope()

    Column(Modifier.fillMaxSize()) {
        CategoriesPageTabs(tabsList = list, pagerState.currentPage) {
            coroutineScope.launch {
                pagerState.animateScrollToPage(it)
            }
        }
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            beyondBoundsPageCount = list.size,
            state = pagerState
        ) { _ ->
            content(pagerState.currentPage)
        }
    }
}

@Composable
@Preview
private fun CategoriesTabLayoutPreview() {
    CategoriesTabLayout { }
}