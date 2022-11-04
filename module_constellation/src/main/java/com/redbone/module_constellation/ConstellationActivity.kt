package com.redbone.module_constellation

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper
import com.redbone.module_constellation.databinding.ActivityConstellationBinding

@Route(path = ARouterHelper.PATH_CONSTELLATION)
class ConstellationActivity : BaseActivity<ActivityConstellationBinding>() {

    override fun getTitleText(): String {
        return getString(R.string.app_title_constellation)
    }

    override fun initView() {

    }

    override fun isShowBack(): Boolean {
        return true
    }

}