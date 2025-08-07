package com.brokenkernel.introspection.coreintrospection

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
public fun OuterContentForCoreIntrospection(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "Hallo")
        Text(text = "Hallo")
        Text(text = "Hallo")
        Text(text = "Hallo")
        Text(text = "Hallo")
    }
}
