package com.redbone.module_app_manager

import android.os.Bundle
import android.os.PersistableBundle
import com.redbone.lib_base.base.BaseActivity

class AppManagerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_app_manager)
    }

}