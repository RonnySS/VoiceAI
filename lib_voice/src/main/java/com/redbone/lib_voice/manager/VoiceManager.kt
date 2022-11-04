package com.redbone.lib_voice.manager

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.baidu.speech.EventListener
import com.baidu.speech.asr.SpeechConstant
import com.baidu.tts.client.SpeechSynthesizer
import com.redbone.lib_voice.asr.VoiceAsr
import com.redbone.lib_voice.tts.VoiceTTS
import com.redbone.lib_voice.wakeup.VoiceWakeUp

object VoiceManager {
    private lateinit var listener: EventListener
    private var TAG = VoiceManager::class.java.simpleName
    const val VOICE_APP_ID = "28039688"
    const val VOICE_APP_KEY = "EIR5gQbkCCoVHZ9d9pT05RSz"
    const val VOICE_APP_SECRET = "Pycov1O4ZUmsGxFtLoGgt7l0M14WxGLD"
    fun initManager(mContext:Context){
        VoiceTTS.initTTS(mContext)
        listener = object:EventListener{
            override fun onEvent(name: String?, params: String?, byte: ByteArray?, offset: Int, len: Int) {

                when(name){
                    SpeechConstant.CALLBACK_EVENT_WAKEUP_READY -> Log.i(TAG, "唤醒准备就绪")
                    SpeechConstant.CALLBACK_EVENT_ASR_READY -> Log.i(TAG, "开始说话")
//                    SpeechConstant.CALLBACK_EVENT_ASR_PARTIAL -> Log.i(TAG, "结束说话")
                }
                if (params == null){
                    return
                }
                when(name){
                    SpeechConstant.CALLBACK_EVENT_WAKEUP_SUCCESS -> Log.i(TAG, "我在")
                    SpeechConstant.CALLBACK_EVENT_WAKEUP_ERROR -> Log.i(TAG, "唤醒失败")
                    SpeechConstant.CALLBACK_EVENT_ASR_READY -> Log.i(TAG, "ASR准备就绪")
                    SpeechConstant.CALLBACK_EVENT_ASR_FINISH -> Log.i(TAG, "ASR识别结束${params}")
                    SpeechConstant.CALLBACK_EVENT_ASR_PARTIAL -> {
                        byte?.let {
                            val nlu = String(byte,offset,len)
                            Log.i(TAG, "ASR动作识别结束${nlu}")
                        }
                    }
                }

            }
        }
        VoiceWakeUp.initWakeUp(mContext, listener)
        VoiceAsr.init(mContext, listener)
    }




    fun setPeople(people:String){
        VoiceTTS.setPeople(people)
    }

    fun setSpeed(speed:String){
        VoiceTTS.setSpeed(speed)

    }

    fun setVolume(volume:String){
        VoiceTTS.setVolume(volume)

    }

    fun start(text: String){
        VoiceTTS.start(text,null)

    }

    fun start(text: String,mOnTTSResultListener: VoiceTTS.OnTTSResultListener){
        VoiceTTS.start(text,mOnTTSResultListener)
    }

    fun pause(){
        VoiceTTS.pause()
    }
    fun stop(){
        VoiceTTS.stop()
    }
    fun resume(){
        VoiceTTS.resume()
    }
    fun release(){
        VoiceTTS.release()
    }

    fun startWakeUp(){
        VoiceWakeUp.startWakeUp()
    }

    fun stopWakeUp(){
        VoiceWakeUp.stopWakeUp()
    }


    fun startAsr(){
        VoiceAsr.startAsr()
    }

    fun stopAsr(){
        VoiceAsr.stopAsr()
    }

    fun cancelAsr(){
        VoiceAsr.cancelAsr()
    }

    fun releaseAsr(){
        VoiceAsr.releaseAsr { p0, p1, p2, p3, p4 -> {} }
    }
}