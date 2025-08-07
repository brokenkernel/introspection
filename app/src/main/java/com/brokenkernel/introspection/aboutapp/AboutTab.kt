package com.brokenkernel.introspection.aboutapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
internal fun AboutTab(modifier: Modifier = Modifier) {
    Text(modifier = modifier, text = "about")
}
