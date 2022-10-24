package com.redbone.lib_voice.tts

import android.content.Context
import com.baidu.tts.client.SpeechError
import com.baidu.tts.client.SpeechSynthesizer
import com.baidu.tts.client.SpeechSynthesizerListener


object VoiceTTS : SpeechSynthesizerListener{
    private var TAG = VoiceTTS::class.java.simpleName
    private const val VOICE_APP_ID = "28039688"
    private const val VOICE_APP_KEY = "EIR5gQbkCCoVHZ9d9pT05RSz"
    private const val VOICE_APP_SECRET = "Pycov1O4ZUmsGxFtLoGgt7l0M14WxGLD"

    fun initTTS(mContext:Context){
        val mSpeechSynthesizer = SpeechSynthesizer.getInstance()
        mSpeechSynthesizer.setContext(mContext)
        mSpeechSynthesizer.setAppId(VOICE_APP_ID)
        mSpeechSynthesizer.setApiKey(VOICE_APP_KEY, VOICE_APP_SECRET)


    }

    override fun onSynthesizeStart(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onSynthesizeDataArrived(p0: String?, p1: ByteArray?, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun onSynthesizeFinish(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onSpeechStart(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onSpeechProgressChanged(p0: String?, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun onSpeechFinish(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onError(p0: String?, p1: SpeechError?) {
        TODO("Not yet implemented")
    }


}