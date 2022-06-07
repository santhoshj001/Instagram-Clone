package com.teamb.paging3sample.presentation.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.teamb.paging3sample.ui.theme.toAppBarContentColor

@Composable
fun SearchToolBar(
    query: String,
    OnTextChange: (String) -> Unit,
    OnSearchSubmit: (String) -> Unit,
    OnCloseCLicked: () -> Unit
) {
    TopAppBar() {
        TextField(
            value = query,
            onValueChange = { OnTextChange(it) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            },
            trailingIcon = {
                IconButton(onClick = {
                    OnTextChange("")
                    OnCloseCLicked
                }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(text = "search here ", Modifier.alpha(50f))
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.toAppBarContentColor
            )
        )
    }
}

@Preview
@Composable
fun preview() {
    SearchToolBar(query = "hello",
        OnTextChange = {},
        OnSearchSubmit = {},
        OnCloseCLicked = {}
    )
}