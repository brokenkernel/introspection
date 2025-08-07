package com.brokenkernel.introspection.aboutapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.brokenkernel.introspection.R
import com.mikepenz.aboutlibraries.ui.compose.android.rememberLibraries
import com.mikepenz.aboutlibraries.ui.compose.m3.LibrariesContainer

@Composable
internal fun LibrariesTab(modifier: Modifier = Modifier) {
    val libraries by rememberLibraries(R.raw.aboutlibraries)
    LibrariesContainer(
        modifier = modifier.fillMaxSize(),
        showAuthor = true,
        showDescription = true,
        showVersion = true,
        showLicenseBadges = true,
        libraries = libraries,
    )
}
