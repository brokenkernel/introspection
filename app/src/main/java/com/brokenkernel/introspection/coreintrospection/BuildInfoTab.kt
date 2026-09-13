package com.brokenkernel.introspection.coreintrospection

import android.content.ClipData
import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.Clipboard
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.toClipEntry
import kotlinx.coroutines.launch
import java.lang.reflect.Field
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

@Composable
internal fun BuildInfoTab(modifier: Modifier = Modifier) {
    val crScope = rememberCoroutineScope()
    val clipboard: Clipboard = LocalClipboard.current
    val localConfig = LocalConfiguration.current

    val buildClass = Build::class
    val buildClassConstants = buildClass.java.declaredFields

    fun copyAllText() {
        val clipData = ClipData.newHtmlText(
            "label TODO",
            "textTODO",
            "html text TODO",
        )
        val clipEntry = clipData.toClipEntry()
        crScope.launch {
            clipboard.setClipEntry(clipEntry)
        }
    }

    val listState = rememberLazyListState()
    Column(modifier = modifier) {
        Row {
            SelectionContainer {
                LazyColumn(
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
                                val constantValue: Any? = buildConstant.get(String)
                                if (constantValue == null) {
                                    Text("null")
                                } else if (buildConstant.type.isArray) {
                                    val arr: Array<*>? = constantValue as? Array<*>
                                    Text(arr.contentDeepToString())
                                } else {
                                    Text(constantValue.toString())
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
                                val isEnum = (lc.returnType.classifier as KClass<*>).java.isEnum
                                val stringifiedConstantValue =
                                    lc.getter.call(localConfig).toString()
                                Text(stringifiedConstantValue)

                                if (isEnum) {
                                    val asInt = stringifiedConstantValue.toInt()

                                    val entries = lc::class.java.enumConstants
                                    val enumValue = entries?.get(asInt).toString()
//                        parseEnum(lc.javaField!!.type as Class<Enum<*>>,
//                        val wat = lc.getter.call(localConfig)
//                        entries.
//                        val enumNameFormat = value.uppercase().replace(" ", "_")
//
                                    Text("[$enumValue]")
                                }
                            },
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
            ) {
                FilledTonalButton(
                    onClick = {
                        copyAllText()
                    },
                ) {
                    Text("copy all")
                }
            }
        }
    }
}
