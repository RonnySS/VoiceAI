package com.redbone.lib_base.helper

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.redbone.lib_base.BuildConfig

object ARouterHelper {

    const val PATH_APP_MANAGER = "/app_manager/launch_activity1"
    const val PATH_CONSTELLATION = "/constellation/launch_activity"
    const val PATH_DEVELOPER = "/developer/launch_activity"
    const val PATH_JOKE = "/joke/launch_activity"
    const val PATH_MAP = "/map/launch_activity"
    const val PATH_SETTING = "/setting/launch_activity"
    const val PATH_VOICE_SETTING = "/voice_setting/launch_activity"
    const val PATH_WEATHER = "/weather/launch_activity"


    fun initHelper(mApplication:Application){
        if (BuildConfig.DEBUG) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(mApplication); // As early as possible, it is recommended to initialize in the Application
    }
}