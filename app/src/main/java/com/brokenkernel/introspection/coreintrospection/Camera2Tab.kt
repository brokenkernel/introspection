package com.brokenkernel.introspection.coreintrospection

import android.os.Build
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

@Composable
internal fun Camera2Tab(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = listState,
    ) {
        stickyHeader {
            Text("Camera Data")
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
