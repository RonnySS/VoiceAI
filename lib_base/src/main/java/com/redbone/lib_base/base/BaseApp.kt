package com.redbone.lib_base.base

import android.app.Application
import android.content.Intent
import com.redbone.lib_base.helper.ARouterHelper
import com.redbone.lib_base.service.InitService

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        ARouterHelper.initHelper(this)
//        startService(Intent(this,InitService::class.java))
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