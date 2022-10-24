plugins {
    if(ModuleConfig.isApp){
        id("com.android.application")
    }else{
        id("com.android.library")
    }
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        if(ModuleConfig.isApp){
//            applicationId = ModuleConfig.MODULE_SETTING
//            versionCode = AppConfig.versionCode
//            versionName = AppConfig.versionName
        }else{
            version = AppConfig.versionCode
        }
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

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
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    kapt(DependenciesConfig.AROUTER_COMPILER)

}