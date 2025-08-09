package com.brokenkernel.introspection.coreintrospection

import android.os.Build
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.Clipboard
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalConfiguration
import java.lang.reflect.Field
import kotlin.reflect.full.memberProperties

@Composable
internal fun BuildInfoTab(modifier: Modifier = Modifier) {
    val clipboard: Clipboard = LocalClipboard.current
    val localConfig = LocalConfiguration.current

    val buildClass = Build::class
    val buildClassConstants = buildClass.java.declaredFields

    val listState = rememberLazyListState()
    LazyColumn(
        modifier = modifier,
        state = listState,
    ) {
        stickyHeader {
            Text("Build Data")
        }
        items(buildClassConstants.toList()) { buildConstant: Field ->
            ListItem(
                headlineContent = {
                    Text(buildConstant.name.orEmpty())
                },
                supportingContent = {
                    if (buildConstant.type.isArray) {
                        Text("Array Value - TODO")
                    } else {
                        val stringifiedConstantValue: String = when (buildConstant.type) {
                            java.lang.String::class.java -> buildConstant.get(String)?.toString().orEmpty()
//                            java.lang.Int::class.java -> buildConstant.getInt(Int).toString()
                            else -> buildConstant.type.toString() + " TODO"
                        }
                        Text(stringifiedConstantValue)
                    }
                },
            )
        }

        stickyHeader {
            Text("Local Config")
        }

        val localConfigConstants = localConfig::class.memberProperties.toList()

        items(localConfigConstants) { lc ->
            ListItem(
                headlineContent = {
                    Text(lc.name)
                },
                supportingContent = {
                    val stringifiedConstantValue = lc.getter.call(localConfig).toString()
                    Text(stringifiedConstantValue)
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
