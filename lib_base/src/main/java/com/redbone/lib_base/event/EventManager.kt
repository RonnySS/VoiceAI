package com.redbone.lib_base.event

import org.greenrobot.eventbus.EventBus
import java.security.MessageDigest
import java.util.*

object EventManager {
    fun register(subscriber : Any){
        EventBus.getDefault().register(subscriber)
    }

    fun unRegister(subscriber : Any){
        EventBus.getDefault().unregister(subscriber)
    }

    //发送事件类
    private fun post(event:MessageEvent){
        EventBus.getDefault().post(event)
    }

    //发送类型
    fun post(type:Int){
        post(MessageEvent(type))
    }

    fun post(type: Int,string: String){
        val event = MessageEvent(type)
        event.stringValue = string
        post(event)
    }

    fun post(type: Int,boolean: Boolean){
        val event = MessageEvent(type)
        event.booleanValue = boolean
        post(event)
    }

    fun post(type: Int,int: Int){
        val event = MessageEvent(type)
        event.intValue = int
        post(event)
    }
}