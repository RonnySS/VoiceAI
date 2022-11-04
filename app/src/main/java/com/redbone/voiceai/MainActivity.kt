package com.redbone.voiceai

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.callback.RequestCallback
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.event.EventManager
import com.redbone.lib_base.event.MessageEvent
import com.redbone.lib_base.helper.ARouterHelper
import com.redbone.lib_base.utils.SPUtils
import com.redbone.voiceai.databinding.ActivityMainBinding
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getTitleText(): String {
        return getString(R.string.app_name)
    }

    override fun initView() {

        startService(Intent(this,VoiceService::class.java))
        SPUtils.getInstance().put("string","High")
        SPUtils.getInstance().getString("string")
        PermissionX
            .init(this)
            .permissions(Manifest.permission.RECORD_AUDIO)
            .request(object :RequestCallback{
                override fun onResult(
                    allGranted: Boolean,
                    grantedList: MutableList<String>,
                    deniedList: MutableList<String>
                ) {
                    if (allGranted){
                        ARouter.getInstance()
                            .build(ARouterHelper.PATH_DEVELOPER)
                            .navigation()
                    }else{
                        Toast.makeText(this@MainActivity, "没有权限！", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            )



    }

    override fun isShowBack(): Boolean {

        return false
    }

}