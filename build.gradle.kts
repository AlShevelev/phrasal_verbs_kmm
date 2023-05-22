plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
}

buildscript {
    repositories {
        gradlePluginPortal()
    }

    val sqlDelightVersion = extra["sqlDelight.version"] as String
    val mokoResourcesVersion = extra["moko.resources.version"] as String

    dependencies {
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
        classpath("dev.icerock.moko:resources-generator:$mokoResourcesVersion")
    }
}
