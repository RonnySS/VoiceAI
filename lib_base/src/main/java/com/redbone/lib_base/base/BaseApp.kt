package com.redbone.lib_base.base

import android.app.Application
import android.content.Intent
import com.redbone.lib_base.helper.ARouterHelper
import com.redbone.lib_base.helper.NotificationHelper
import com.redbone.lib_base.service.InitService
import com.redbone.lib_voice.manager.VoiceManager

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        ARouterHelper.initHelper(this)
        NotificationHelper.initHelper(this)
        VoiceManager.initManager(this)
        startService(Intent(this,InitService::class.java))
    }



    companion object {
        @JvmStatic
        private lateinit var INSTANCE:Application

        @JvmStatic
        fun getInstance():Application{
            return INSTANCE
        }
    }

}