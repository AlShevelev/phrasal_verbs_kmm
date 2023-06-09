plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.squareup.sqldelight")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    android()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    val coroutinesVersion = extra["coroutines.version"] as String
    val sqlDelightVersion = extra["sqlDelight.version"] as String
    val koinVersion = extra["koin.version"] as String
    val mokoResourcesVersion = extra["moko.resources.version"] as String
    val androidxActivityVersion = extra["androidx.activity.version"] as String
    val androidxAppcompatVersion = extra["androidx.appcompat.version"] as String
    val androidxCoreKtxVersion = extra["androidx.core-ktx.version"] as String

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":sharedCore"))

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")

                api("io.insert-koin:koin-core:$koinVersion")

                api("dev.icerock.moko:resources:$mokoResourcesVersion")
                api("dev.icerock.moko:resources-compose:$mokoResourcesVersion")

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.activity:activity-compose:$androidxActivityVersion")
                api("androidx.appcompat:appcompat:$androidxAppcompatVersion")
                api("androidx.core:core-ktx:$androidxCoreKtxVersion")

                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.shevelev.phrasalverbs"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}

sqldelight {
    database("AppStorageDatabase") {
        packageName = "com.shevelev.phrasalverbs.data.api.appstorage"
        sourceFolders = listOf("sqldelight/appstorage")
    }

    database("KeyValueStorageDatabase") {
        packageName = "com.shevelev.phrasalverbs.data.api.keyvaluestorage"
        sourceFolders = listOf("sqldelight/keyvaluestorage")
    }

    linkSqlite = true
}

multiplatformResources {
    multiplatformResourcesPackage = "com.shevelev.phrasalverbs.resources" // required
    iosBaseLocalizationRegion = "ru" // optional, default "en"
}