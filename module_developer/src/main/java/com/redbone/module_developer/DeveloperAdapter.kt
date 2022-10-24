package com.redbone.module_developer

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class DeveloperAdapter: BaseMultiItemQuickAdapter<DeveloperListData,BaseViewHolder> {

    constructor(list: MutableList<DeveloperListData>):super(list){
        addItemType(ItemType.CONTENT.itemType,R.layout.layout_developer_content)
        addItemType(ItemType.TITLE.itemType,R.layout.layout_developer_title)
    }

    override fun convert(holder: BaseViewHolder, item: DeveloperListData) {
        when(holder.itemViewType){
            ItemType.TITLE.itemType ->{
                holder.setText(R.id.mTvDeveloperTitle,item.text)
            }
            ItemType.CONTENT.itemType ->{
                holder.setText(R.id.mTvDeveloperContent,item.text)
            }
        }
    }
}