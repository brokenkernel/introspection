package com.brokenkernel.introspection.infrastructure

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.brokenkernel.introspection.R

internal enum class IntrospectionDestinations(
    @param:StringRes val label: Int,
    @DrawableRes val icon: Int,
    @param:StringRes val contentDescription: Int,
) {
    BUILD(R.string.build, R.drawable.build_24px, R.string.build),
    CAMERA2(R.string.camera, R.drawable.camera_24px, R.string.camera),
    ABOUT(R.string.about, R.drawable.info_24px, R.string.about),
    LIBRARIES(R.string.licences, R.drawable.license_24px, R.string.licences),
}
