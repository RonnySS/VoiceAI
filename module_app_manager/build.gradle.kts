plugins {
    if(ModuleConfig.isApp){
        id("com.android.application")
    }else{
        id("com.android.library")
    }

    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        if(ModuleConfig.isApp){
            applicationId = ModuleConfig.MODULE_APP_MANAGER
            versionCode = AppConfig.versionCode
            versionName = AppConfig.versionName
        }else{
            version = AppConfig.versionCode
        }
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "roguard-rules.pro")
        }
    }

    sourceSets{
        getByName("main"){
            if(ModuleConfig.isApp){
                manifest.srcFile("src/main/manifest/AndroidManifest.xml")
            }else{
                manifest.srcFile("src/main/AndroidManifest.xml")
            }
        }
    }
}

dependencies {
    implementation(project(":lib_base"))
}