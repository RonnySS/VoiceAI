package com.redbone.module_map

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper

@Route(path = ARouterHelper.PATH_MAP)
class MapActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_map
    }

    override fun getTitleText(): String {
        return getString(R.string.app_title_map)
    }

    override fun initView() {

    }

    override fun isShowBack(): Boolean {
        return true
    }
}