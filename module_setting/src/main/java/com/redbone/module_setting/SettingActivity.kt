package com.redbone.module_setting

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper
import com.redbone.module_setting.databinding.ActivitySettingBinding

@Route(path = ARouterHelper.PATH_SETTING)
class SettingActivity : BaseActivity<ActivitySettingBinding>() {

    override fun getTitleText(): String {
        return getString(R.string.app_title_setting)
    }

    override fun initView() {

    }

    override fun isShowBack(): Boolean {
        return true
    }
}