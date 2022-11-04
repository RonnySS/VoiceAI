package com.redbone.voiceai

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.redbone.lib_base.helper.NotificationHelper
import com.redbone.lib_voice.manager.VoiceManager

class VoiceService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
//        initService()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        bindNotification()
        //系统自带的保活手段，但还是不能保证可以及时复活
        return START_STICKY_COMPATIBILITY
    }

    //绑定通知栏
    private fun bindNotification(){
        startForeground(1000,NotificationHelper.bindVoiceService("aaaaa正在运行"))
    }

    //只能在主线程初始化，所以这个方法应该用不到了
    private fun initService(){
        VoiceManager.initManager(this)
    }
}