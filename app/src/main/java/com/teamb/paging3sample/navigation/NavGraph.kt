package com.teamb.paging3sample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.teamb.paging3sample.presentation.HomeScreen

@OptIn(ExperimentalPagingApi::class)
@Composable
fun setupNavGraph(navController: NavHostController) {


    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.Search.route) {
            //SearchScreen(navController)
        }
    }
}