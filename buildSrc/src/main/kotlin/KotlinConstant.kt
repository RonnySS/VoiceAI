object KotlinConstant{
    const val kotlin_version = "1.6.10"
    const val gradle_version = "7.0.4"
}

object AppConfig{
    const val compileSdk = 32
    const val buildToolsVersion = "29.0.2"
    const val applicationId = "com.redbone.voiceai"
    const val minSdk = 21
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0"

}

object DependenciesConfig{

    const val APP_COMPAT = "androidx.appcompat:appcompat:1.2.0"
    const val KTX_CORE = "androidx.core:core-ktx:1.3.2"
    const val MATERIAL = "com.google.android.material:material:1.3.0"
    const val EVENT_BUS = "org.greenrobot:eventbus:3.2.0"

    const val AROUTER = "com.alibaba:arouter-api:1.5.2"
    const val AROUTER_COMPILER = "com.alibaba:arouter-compiler:1.5.2"
    const val BRVAH_ADAPT = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.8"
}

object ModuleConfig{
    var isApp = false
    const val MODULE_APP_MANAGER = "com.imooc.module_app_manager"
    const val MODULE_CONSTELLATION = "com.imooc.module_constellation"
    const val MODULE_DEVELOPER = "com.imooc.module_developer"
    const val MODULE_JOKE = "com.imooc.module_joke"
    const val MODULE_MAP = "com.imooc.module_map"
    const val MODULE_SETTING = "com.imooc.module_setting"
    const val MODULE_VOICE_SETTING = "com.imooc.module_voice_setting"
    const val MODULE_WEATHER = "com.imooc.module_weather"
}
