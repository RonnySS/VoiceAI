package com.redbone.module_voice_setting

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper

@Route(path = ARouterHelper.PATH_VOICE_SETTING)
class VoiceSettingActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_voice_setting
    }

    override fun getTitleText(): String {
        return getString(R.string.app_title_voice_setting)
    }

    override fun initView() {

    }

    override fun isShowBack(): Boolean {
        return true
    }
}