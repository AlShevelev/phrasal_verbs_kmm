plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("multiplatform").apply(false)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    id("org.jetbrains.compose").apply(false)
    id("org.jetbrains.kotlin.plugin.compose").apply(false)
}

buildscript {
    repositories {
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.sqldelight.gradle.plugin)
        classpath(libs.moko.resources.generator)
    }
}
