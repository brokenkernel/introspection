package com.brokenkernel.introspection.coreintrospection

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun HomeScreen(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = listState,
    ) {
        item {
            ListItem(
                headlineContent = {
                    Text(text = "Hallo1")
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text(text = "Hallo2")
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text(text = "Hallo3")
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text(text = "Hallo4")
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text(text = "Hallo5")
                },
            )
        }
    }
}
