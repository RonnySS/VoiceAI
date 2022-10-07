package com.redbone.module_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.redbone.lib_base.BaseActivity

class MapActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
    }
}