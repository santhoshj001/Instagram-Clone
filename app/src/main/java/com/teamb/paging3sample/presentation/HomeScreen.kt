package com.teamb.paging3sample.presentation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.teamb.paging3sample.navigation.Screen
import com.teamb.paging3sample.presentation.common.HomeTopBar
import com.teamb.paging3sample.presentation.common.ListContent

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    var getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(
                onSearchClicked = {
                    navHostController.navigate(Screen.Search.route)
                }
            )
        },
        content = {



            ListContent(items = getAllImages)
        }
    )

}