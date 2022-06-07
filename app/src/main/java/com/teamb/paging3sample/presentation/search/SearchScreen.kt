package com.teamb.paging3sample.presentation.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import com.teamb.paging3sample.presentation.common.ListContent

@OptIn(ExperimentalPagingApi::class)
@Composable
fun SearchScreen(
    navHostController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val query = searchViewModel.searchQuery
    val images = searchViewModel.searchImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SearchToolBar(
                query = query,
                OnTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                OnSearchSubmit = {
                    searchViewModel.search(it)
                },
                OnCloseCLicked = {
                    navHostController.popBackStack()
                }
            )
        },
        content = {
            ListContent(items = images)
        }
    )
}