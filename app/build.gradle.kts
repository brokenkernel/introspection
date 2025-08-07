import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.aboutLibraries)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.protobuf)
    alias(libs.plugins.sortDependencies)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.versions)
}

android {
    namespace = "com.brokenkernel.introspection"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.brokenkernel.introspection"
        minSdk = 26
        targetSdk = 36
        versionCode = 7
        versionName = "0.0.$versionCode"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
        explicitApi()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeCompiler {
        includeSourceInformation = true
        includeTraceMarkers = true
        featureFlags = setOf()
    }
    lint {
        baseline = file("lint-baseline.xml")
    }
}

dependencies {
    implementation(enforcedPlatform(libs.androidx.compose.bom))
    implementation(enforcedPlatform(libs.kotlin.bom))
    implementation(libs.aboutlibraries.compose.m3)
    implementation(libs.aboutlibraries.core)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material.materialIconsExtended)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material3.adaptive.navigation.suite)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.io.github.raamcosta.composeDestinations.core)

    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.tooling)

    testImplementation(libs.junit)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)

    ksp(libs.hilt.compiler)
    ksp(libs.io.github.raamcosta.composeDestinations.ksp)
}
