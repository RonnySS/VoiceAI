package com.redbone.lib_base.helper

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

@SuppressLint("StaticFieldLeak")
object NotificationHelper {
    private const val CHANNEL_ID = "ai_voice_service"
    private const val CHANNEL_NAME = "语音服务"
    private lateinit var mContext:Context
    private lateinit var nm:NotificationManager

    fun initHelper(mContext:Context){
        this.mContext = mContext
        nm = mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        setBindVoiceChannel()
    }

    private fun setBindVoiceChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //创建渠道对象
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH)
            //设置该渠道通知的特征
            channel.enableLights(true)
            channel.enableVibration(true)
            channel.setShowBadge(false)
            //创建真正的渠道
            nm.createNotificationChannel(channel)
        }
    }

    //绑定语音服务
    fun bindVoiceService(contentText:String): Notification{
        //创建通知栏对象
        val notificationCompat:NotificationCompat.Builder = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationCompat.Builder(mContext, CHANNEL_ID)
        }else{
            NotificationCompat.Builder(mContext)
        }
        //设置标题
        notificationCompat.setContentTitle(CHANNEL_NAME)
        notificationCompat.setContentText(contentText)
        notificationCompat.setWhen(System.currentTimeMillis())
        notificationCompat.setAutoCancel(false)
        return notificationCompat.build()

    }


}