package com.redbone.module_voice_setting

import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import javax.sql.CommonDataSource

class CommonAdapter(val dataSource: MutableList<String>): BaseQuickAdapter<String, BaseViewHolder>(R.layout.string_item,dataSource) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.speaker_name,dataSource[holder.layoutPosition])
    }


}