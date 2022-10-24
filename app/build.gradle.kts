plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
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

        kapt {
            arguments {
                arg("AROUTER_MODULE_NAME", project.name)
            }
        }

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

//    implementation(DependenciesConfig.KTX_CORE)
//    implementation(DependenciesConfig.APP_COMPAT)
//    implementation(DependenciesConfig.MATERIAL)
    implementation(project(":lib_base"))
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    if(!ModuleConfig.isApp){
        //if this module is not a "library"
        implementation(project(":module_app_manager"))
        implementation(project(":module_constellation"))
        implementation(project(":module_developer"))
        implementation(project(":module_joke"))
        implementation(project(":module_map"))
        implementation(project(":module_setting"))
        implementation(project(":module_voice_setting"))
        implementation(project(":module_weather"))

    }

    kapt(DependenciesConfig.AROUTER_COMPILER)
}