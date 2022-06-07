package com.teamb.paging3sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.teamb.paging3sample.navigation.setupNavGraph
import com.teamb.paging3sample.ui.theme.Paging3SampleTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Paging3SampleTheme {
                val navHostController = rememberNavController()
                setupNavGraph(navController = navHostController)
            }
        }
    }
}

