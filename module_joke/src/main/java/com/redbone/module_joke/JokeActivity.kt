package com.redbone.module_joke

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper

@Route(path = ARouterHelper.PATH_JOKE)
class JokeActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_joke
    }

    override fun getTitleText(): String {
        return getString(R.string.app_title_joke)
    }

    override fun initView() {

    }

    //随便写一点注释
    override fun isShowBack(): Boolean {
        return true
    }
}