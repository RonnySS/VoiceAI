plugins {
    id("com.android.application")
    kotlin("android")
}


android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

    }

    signingConfigs {
        register("release"){
            keyAlias = "imooc"
            keyPassword = "123456"
            storeFile = file("src/main/jks/SignFile")
            storePassword = "123456"

        }
    }


    //编译类型，混淆
    buildTypes {
        getByName("debug"){

        }
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "roguard-rules.pro")
        }
    }

    android.applicationVariants.all{
        val buildType = this.buildType
        outputs.all {
            if(this is com.android.build.gradle.internal.api.ApkVariantOutputImpl){
                this.outputFileName = "AI_V${defaultConfig.versionName}_${buildType.name}.apk"
            }
        }
    }

    //依赖操作
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_12
        targetCompatibility = JavaVersion.VERSION_12
    }
}

dependencies {

    implementation(DependenciesConfig.KTX_CORE)
    implementation(DependenciesConfig.APP_COMPAT)
    implementation(DependenciesConfig.MATERIAL)
//    implementation(DependenciesConfig.APP_COMPAT)
}