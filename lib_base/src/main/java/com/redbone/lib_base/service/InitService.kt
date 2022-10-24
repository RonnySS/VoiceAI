package com.redbone.lib_base.service

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.redbone.lib_base.helper.NotificationHelper

class InitService : IntentService("InitService") {

    override fun onHandleIntent(intent: Intent?) {
        Log.d("TAG", "执行了：onHandleIntent: ")
        NotificationHelper.initHelper(this )
    }

}