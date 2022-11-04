package com.redbone.lib_voice.asr

import android.content.Context
import com.baidu.speech.EventListener
import com.baidu.speech.EventManager
import com.baidu.speech.EventManagerFactory
import com.baidu.speech.asr.SpeechConstant
import com.redbone.lib_voice.voice_utils.AuthUtil
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

object VoiceAsr {
    private lateinit var asr:EventManager
    private lateinit var asrJson:String
    fun init(mContext:Context,listener:EventListener){
        val map = AuthUtil.getParam()
        map[SpeechConstant.ACCEPT_AUDIO_VOLUME] = true
        map[SpeechConstant.ACCEPT_AUDIO_DATA] = false
        map[SpeechConstant.DISABLE_PUNCTUATION] = false
        map[SpeechConstant.PID] = 15363
        asrJson = JSONObject(map).toString()
        asr = EventManagerFactory.create(mContext,"asr")
        asr.registerListener(listener)
    }

    fun startAsr(){
        asr.send(SpeechConstant.ASR_START,asrJson,null,0,0)
    }

    fun stopAsr(){
        asr.send(SpeechConstant.ASR_STOP,null,null,0,0)
    }

    fun cancelAsr(){
        asr.send(SpeechConstant.ASR_CANCEL,null,null,0,0)
    }

    fun releaseAsr(listener: EventListener){
        asr.unregisterListener(listener)
    }
}