package com.teamb.paging3sample.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Search : Screen("search-screen")
}
