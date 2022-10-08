package com.redbone.voiceai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.redbone.lib_base.event.EventManager
import com.redbone.lib_base.event.MessageEvent
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {
    lateinit var button1:Button
    lateinit var button2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventManager.register(this)
        button1 = findViewById(R.id.BTN_button1)
        button2 = findViewById(R.id.BTN_button2)
        button1.setOnClickListener {
            EventManager.post(1111)
        }

        button2.setOnClickListener {
            EventManager.post(2222,"Hello EventBus ")
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent){
        when(event.type){
            1111 -> {
                Toast.makeText(this, "1111", Toast.LENGTH_SHORT).show()
            }
            2222 -> {
                Toast.makeText(this, "2222+${event.stringValue}", Toast.LENGTH_SHORT).show()
            }
        }

    }
}