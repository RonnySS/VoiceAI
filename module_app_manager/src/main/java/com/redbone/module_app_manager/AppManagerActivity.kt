package com.redbone.module_app_manager

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper

@Route(path = ARouterHelper.PATH_APP_MANAGER)
class AppManagerActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_app_manager
    }

    override fun getTitleText(): String {
        return getString(R.string.app_title_app_manager)
    }

    override fun initView() {

    }

    override fun isShowBack(): Boolean {
        return true
    }


}