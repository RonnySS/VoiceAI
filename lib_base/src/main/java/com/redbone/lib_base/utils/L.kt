package com.redbone.lib_base.utils

import android.util.Log

object L {
    private const val TAG:String = "AiVoice"
    fun i(text:String?){
        text?.let {
            Log.i(TAG,it)
        }
    }

    fun e(text:String?){
        text?.let {
            Log.e(TAG,it)
        }
    }
}