plugins {

    alias(libs.plugins.aboutLibraries)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.lint) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    alias(libs.plugins.dependencyAnalysis)
    alias(libs.plugins.google.gms.google.services) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.protobuf) apply false
    alias(libs.plugins.sortDependencies) apply false
    alias(libs.plugins.versionCatalogUpdate)
    alias(libs.plugins.aboutLibrariesAndroid) apply false
    kotlin("plugin.power-assert") version "2.3.10" apply false
}