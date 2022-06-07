package com.teamb.paging3sample.presentation.common

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.teamb.paging3sample.ui.theme.toAppBarBackgroundColor
import com.teamb.paging3sample.ui.theme.toAppBarContentColor

@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(title = {
        Text(text = "Home", color = MaterialTheme.colors.toAppBarContentColor)
    }, backgroundColor = MaterialTheme.colors.toAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
        }
    )
}

@Preview
@Composable
fun preview(){
    HomeTopBar {

    }
}