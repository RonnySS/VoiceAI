package com.redbone.lib_voice.tts

import android.content.Context
import android.util.Log
import com.baidu.tts.client.SpeechError
import com.baidu.tts.client.SpeechSynthesizer
import com.baidu.tts.client.SpeechSynthesizerListener
import com.baidu.tts.client.TtsMode
import com.redbone.lib_voice.manager.VoiceManager
import com.redbone.lib_voice.manager.VoiceManager.VOICE_APP_KEY


object VoiceTTS : SpeechSynthesizerListener{
    private var TAG = VoiceTTS::class.java.simpleName
    lateinit var mSpeechSynthesizer:SpeechSynthesizer

    var mOnTTSResultListener:OnTTSResultListener? = null

    fun initTTS(mContext:Context){
        mSpeechSynthesizer = SpeechSynthesizer.getInstance()
        mSpeechSynthesizer.setContext(mContext)
        mSpeechSynthesizer.setAppId(VoiceManager.VOICE_APP_ID)
        mSpeechSynthesizer.setApiKey(VoiceManager.VOICE_APP_KEY, VoiceManager.VOICE_APP_SECRET)
        mSpeechSynthesizer.setSpeechSynthesizerListener(this)

        setPeople("1")
        setSpeed("5")
        setVolume("5")


        //init code
        mSpeechSynthesizer.initTts(TtsMode.ONLINE)
        


    }


    fun setPeople(people:String){
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEAKER,people)

    }

    fun setSpeed(speed:String){
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEED,speed)

    }

    fun setVolume(volume:String){
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_VOLUME,volume)

    }

    override fun onSynthesizeStart(p0: String?) {
        Log.d(TAG, "onSynthesizeStart: 合成开始")
    }

    override fun onSynthesizeDataArrived(p0: String?, p1: ByteArray?, p2: Int, p3: Int) {
        Log.d(TAG, "onSynthesizeDataArrived: ")
    }

    override fun onSynthesizeFinish(p0: String?) {
        Log.d(TAG, "onSynthesizeFinish: ")
    }

    override fun onSpeechStart(p0: String?) {
        Log.d(TAG, "onSpeechStart: ")
    }

    override fun onSpeechProgressChanged(p0: String?, p1: Int) {
        Log.d(TAG, "onSpeechProgressChanged: ")
    }

    override fun onSpeechFinish(p0: String?) {
        Log.d(TAG, "onSpeechFinish: ")
        mOnTTSResultListener?.ttsEnd()
    }

    override fun onError(p0: String?, p1: SpeechError?) {
        Log.d(TAG, "onError:$p0+$p1 ")
    }



    fun start(text:String,mOnTTSResultListener:OnTTSResultListener?){
        this.mOnTTSResultListener = mOnTTSResultListener
        mSpeechSynthesizer.speak(text)
    }

    fun pause(){
        mSpeechSynthesizer.pause()
    }
    fun stop(){
        mSpeechSynthesizer.stop()
    }
    fun resume(){
        mSpeechSynthesizer.resume()
    }
    fun release(){
        mSpeechSynthesizer.release()
    }

    interface OnTTSResultListener{
        fun ttsEnd()

    }



}