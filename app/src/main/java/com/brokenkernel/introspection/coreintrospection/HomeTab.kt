package com.brokenkernel.introspection.coreintrospection

import android.os.Build
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.Clipboard
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalConfiguration

@Composable
internal fun HomeTab(modifier: Modifier = Modifier) {
    val localConfig = LocalConfiguration.current

    val clipboard: Clipboard = LocalClipboard.current

    val listState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = listState,
    ) {
        stickyHeader {
            Text("Build Data")
        }

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
        item {
            MinimumAPIListItemVersionS(
                apiLevel = Build.VERSION_CODES.S,
                datum = {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        Text(Build.ODM_SKU)
                    }
                },
            )
        }
    }
}

@Composable
private fun MinimumAPIListItemVersionS(
    apiLevel: Int,
    modifier: Modifier = Modifier,
    datum: @Composable () -> Unit,
) {
    val isValid = Build.VERSION.SDK_INT >= apiLevel
    val currentModifier = if (isValid) {
        modifier
    } else {
        Modifier.alpha(0.5f) // maybe a better way to describe "disabled" ?
    }
    ListItem(
        headlineContent = {
            Text("ODM_SKU")
        },
        supportingContent = {
            if (isValid) {
                datum()
            }
        },
        trailingContent = {
            Text("Minimum API ${Build.VERSION_CODES.S}")
        },
        modifier = currentModifier,
    )
}
