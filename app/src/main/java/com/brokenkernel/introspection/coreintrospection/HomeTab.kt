package com.brokenkernel.introspection.coreintrospection

import android.os.Build
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun HomeTab(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = listState,
    ) {
        item {
            ListItem(
                headlineContent = {
                    Text("BOARD")
                },
                supportingContent = {
                    Text(Build.BOARD)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("BOOTLOADER")
                },
                supportingContent = {
                    Text(Build.BOOTLOADER)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("BRAND")
                },
                supportingContent = {
                    Text(Build.BRAND)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("DEVICE")
                },
                supportingContent = {
                    Text(Build.DEVICE)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("DISPLAY")
                },
                supportingContent = {
                    Text(Build.DISPLAY)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("FINGERPRINT")
                },
                supportingContent = {
                    Text(Build.FINGERPRINT)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("HARDWARE")
                },
                supportingContent = {
                    Text(Build.HARDWARE)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("HOST")
                },
                supportingContent = {
                    Text(Build.HOST)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("ID")
                },
                supportingContent = {
                    Text(Build.ID)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("MANUFACTURER")
                },
                supportingContent = {
                    Text(Build.MANUFACTURER)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("MODEL")
                },
                supportingContent = {
                    Text(Build.MODEL)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("PRODUCT")
                },
                supportingContent = {
                    Text(Build.PRODUCT)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("TAGS")
                },
                supportingContent = {
                    Text(Build.TAGS)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("TIME")
                },
                supportingContent = {
                    Text(Build.TIME.toString())
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("TYPE")
                },
                supportingContent = {
                    Text(Build.TYPE)
                },
            )
        }
        item {
            ListItem(
                headlineContent = {
                    Text("USER")
                },
                supportingContent = {
                    Text(Build.USER)
                },
            )
        }
    }
}
