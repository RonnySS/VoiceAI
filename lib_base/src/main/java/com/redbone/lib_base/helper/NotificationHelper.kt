package com.redbone.lib_base.helper

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

@SuppressLint("StaticFieldLeak")
object NotificationHelper {
    private const val CHANNEL_ID = "ai_voice_service"
    private const val CHANNEL_NAME = "语音服务"
    private lateinit var mContext:Context
    private lateinit var nm:NotificationManager

    fun initHelper(mContext:Context){
        this.mContext = mContext
        nm = mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    }

    private fun setBindVoiceChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.enableVibration(true)
            channel.setShowBadge(false)
            nm.createNotificationChannel(channel)
        }
    }


}