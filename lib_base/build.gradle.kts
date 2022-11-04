plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        version = AppConfig.versionCode

        javaCompileOptions {
            annotationProcessorOptions {
                arguments(mapOf("AROUTER_MODULE_NAME" to project.name))
            }
        }
        kapt {
            arguments {
                arg("AROUTER_MODULE_NAME", project.name)
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "roguard-rules.pro")
        }
    }
}

dependencies {
    api(DependenciesConfig.KTX_CORE)
    api(DependenciesConfig.APP_COMPAT)
    api(DependenciesConfig.MATERIAL)
    //module lib
    api(project(":lib_network"))
    api(project(":lib_voice"))
    api(DependenciesConfig.EVENT_BUS)
    api(DependenciesConfig.BRVAH_ADAPT)
    api(DependenciesConfig.PERMISSION_X)

    //Arouter
    api(DependenciesConfig.AROUTER)
    kapt(DependenciesConfig.AROUTER_COMPILER)
    api(DependenciesConfig.BRVAH_ADAPT)
}