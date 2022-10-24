package com.redbone.voiceai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.event.EventManager
import com.redbone.lib_base.event.MessageEvent
import com.redbone.lib_base.helper.ARouterHelper
import com.redbone.lib_base.service.InitService
import com.redbone.lib_base.utils.SPUtils
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getTitleText(): String {
        return getString(R.string.app_name)
    }

    override fun initView() {
//        ARouter.getInstance()
//            .build(ARouterHelper.PATH_DEVELOPER)
//            .navigation()

        startService(Intent(this,InitService::class.java))
        SPUtils.getInstance().put("string","High")
        SPUtils.getInstance().getString("string")


    }

    override fun isShowBack(): Boolean {
        return false
    }

}