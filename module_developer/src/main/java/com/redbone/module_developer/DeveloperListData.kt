package com.redbone.module_developer

import com.chad.library.adapter.base.entity.MultiItemEntity

data class DeveloperListData(
    override var itemType:Int,
    var text:String
):MultiItemEntity