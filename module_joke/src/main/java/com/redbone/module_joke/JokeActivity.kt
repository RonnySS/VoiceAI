package com.redbone.module_joke

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper
import com.redbone.module_joke.databinding.ActivityJokeBinding

@Route(path = ARouterHelper.PATH_JOKE)
class JokeActivity : BaseActivity<ActivityJokeBinding>() {

    override fun getTitleText(): String {
        return getString(R.string.app_title_joke)
    }

    override fun initView() {

    }

    override fun isShowBack(): Boolean {
        return true
    }
}