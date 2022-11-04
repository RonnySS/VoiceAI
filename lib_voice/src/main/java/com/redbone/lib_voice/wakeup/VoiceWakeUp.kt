package com.redbone.lib_voice.wakeup

import android.content.Context
import android.util.Log
import com.baidu.speech.EventListener
import com.baidu.speech.EventManager
import com.baidu.speech.EventManagerFactory
import com.baidu.speech.asr.SpeechConstant
import com.redbone.lib_voice.voice_utils.AuthUtil
import org.json.JSONObject

object VoiceWakeUp {
    private var TAG = VoiceWakeUp::class.java.simpleName
    private lateinit var wakeUpJson:String
    private lateinit var wp: EventManager
    fun initWakeUp(mContext:Context,listener: EventListener){
        val map = AuthUtil.getParam()

        map[SpeechConstant.WP_WORDS_FILE] = "assets:///WakeUp.bin"
        map[SpeechConstant.ACCEPT_AUDIO_VOLUME] = false
        wakeUpJson = JSONObject(map).toString()
        Log.d(TAG, "initWakeUp: $wakeUpJson")

        wp = EventManagerFactory.create(mContext,"wp")
        wp.registerListener(listener)
    }

    //启动唤醒
    fun startWakeUp(){
//        Log.d(TAG, "startWakeUp: 启动唤醒")
        wp.send(SpeechConstant.WAKEUP_START, wakeUpJson,null,0,0)
    }

    fun stopWakeUp(){
        Log.d(TAG, "stopWakeUp: 停止唤醒")
        wp.send(SpeechConstant.WAKEUP_STOP,null ,null,0,0)
    }

}