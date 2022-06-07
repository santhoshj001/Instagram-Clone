package com.teamb.paging3sample.presentation.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.teamb.paging3sample.ui.theme.toAppBarBackgroundColor
import com.teamb.paging3sample.ui.theme.toAppBarContentColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchToolBar(
    query: String,
    OnTextChange: (String) -> Unit,
    OnSearchSubmit: (String) -> Unit,
    OnCloseCLicked: () -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    TopAppBar(
        backgroundColor = MaterialTheme.colors.toAppBarBackgroundColor
    ) {
        TextField(
            value = query,
            onValueChange = { OnTextChange(it) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colors.toAppBarContentColor
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    OnCloseCLicked()
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close",
                        tint = MaterialTheme.colors.toAppBarContentColor
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(text = "search here ",color = Color.LightGray)
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.toAppBarContentColor
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    OnSearchSubmit(query)
                    keyboardController?.hide()
                }
            ), keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
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