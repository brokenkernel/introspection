package com.brokenkernel.introspection.coreintrospection

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.brokenkernel.introspection.infrastructure.IntrospectionDestinations

@Composable
internal fun MasterScaffold(modifier: Modifier = Modifier) {
    var currentDestination by rememberSaveable { mutableStateOf(IntrospectionDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            IntrospectionDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = stringResource(it.contentDescription),
                        )
                    },
                    label = { Text(stringResource(it.label)) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it },
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
    ) {
        when (currentDestination) {
            IntrospectionDestinations.HOME -> HomeScreen()
        }
    }
}

@Composable
internal fun OuterContentForCoreIntrospection(modifier: Modifier = Modifier) {
    MasterScaffold(modifier)
}
