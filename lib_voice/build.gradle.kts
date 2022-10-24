plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        version = AppConfig.versionCode
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "roguard-rules.pro")
        }
    }
}

dependencies {
    api(fileTree(mapOf("dir" to "libs","include" to listOf("*.jar"))))
}