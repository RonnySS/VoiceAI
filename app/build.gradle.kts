plugins {
    id("com.android.application")
    kotlin("android")
}


android {
    compileSdk = 32
//    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = "com.redbone.voiceai"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

    }

//    signingConfigs {
//        register("release"){
//            keyAlias = "imooc"
//            keyPassword = "123456"
//            storeFile = file("src/main/jks/Untitled")
//            storePassword = "123456"
//
//        }
//    }


    //编译类型，混淆
    buildTypes {
        getByName("debug"){

        }
        getByName("release") {
            isMinifyEnabled = false
//            signingConfig = signingConfigs.getByName("release")
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "roguard-rules.pro")
        }
    }

//    android.applicationVariants.all{
//        val buildType = this.buildType
//        outputs.all {
//            if(this is com.android.build.gradle.internal.api.ApkVariantOutputImpl){
//                this.outputFileName = "AI_V${defaultConfig.versionName}_${buildType.name}.apk"
//            }
//        }
//    }

    //依赖操作
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_12
        targetCompatibility = JavaVersion.VERSION_12
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("com.google.android.material:material:1.3.0")
//    implementation(DependenciesConfig.APP_COMPAT)
}