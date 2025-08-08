package com.brokenkernel.introspection.infrastructure

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Copyright
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.brokenkernel.introspection.R

internal enum class IntrospectionDestinations(
    @param:StringRes val label: Int,
    val icon: ImageVector,
    @param:StringRes val contentDescription: Int,
) {
    BUILD(R.string.home, Icons.Default.Build, R.string.home),
    CAMERA2(R.string.camera, Icons.Default.Camera, R.string.camera),
    ABOUT(R.string.about, Icons.Default.Info, R.string.about),
    LIBRARIES(R.string.licences, Icons.Default.Copyright, R.string.licences),


}
