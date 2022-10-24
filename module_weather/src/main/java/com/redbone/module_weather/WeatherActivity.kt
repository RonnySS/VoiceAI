package com.redbone.module_weather

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper

@Route(path = ARouterHelper.PATH_WEATHER)
class WeatherActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_weather
    }

    override fun getTitleText(): String {
        return getString(R.string.app_title_weather)
    }

    override fun initView() {

    }

    override fun isShowBack(): Boolean {
        return true
    }
}