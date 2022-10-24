package com.redbone.module_developer

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper

@Route(path = ARouterHelper.PATH_DEVELOPER)
class DeveloperActivity : BaseActivity() {

    private val mTypeTitle = ItemType.TITLE.itemType
    private val mTypeContent = ItemType.CONTENT.itemType
    private val mList = ArrayList<DeveloperListData>()

    override fun getLayoutId(): Int {
        return R.layout.activity_developer
    }

    override fun getTitleText(): String {
        return getString(R.string.app_title_developer)
    }

    override fun initView() {
        initData()
        initRecycleView()
    }

    override fun isShowBack(): Boolean {
        return true
    }

    private fun initData(){
        val dataArray = resources.getStringArray(R.array.DeveloperListArray)
        dataArray.forEach {
            if (it.contains("[")){
                //is title
                addTypeItem(mTypeTitle,it.replace("[","").replace("]",""))
            }else{
                addTypeItem(mTypeContent,it)
            }
        }

    }

    private fun initRecycleView(){
        val recyclerView:RecyclerView = findViewById(R.id.RV_developer)
        val mAdapter = DeveloperAdapter(mList)
        recyclerView.layoutManager = LinearLayoutManager(baseContext,RecyclerView.VERTICAL,false)
        recyclerView.adapter = mAdapter
        mAdapter.setOnItemClickListener(object :OnItemClickListener{
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                startForActivity(position)

            }
        })


    }

    private fun addTypeItem(type:Int, text:String){
        mList.add(DeveloperListData(type,text))
    }

    private fun startForActivity(position:Int){
        when(position){
            1 -> ARouter.getInstance().build(ARouterHelper.PATH_APP_MANAGER).navigation()
            2 -> ARouter.getInstance().build(ARouterHelper.PATH_CONSTELLATION).navigation()
            3 -> ARouter.getInstance().build(ARouterHelper.PATH_JOKE).navigation()
            4 -> ARouter.getInstance().build(ARouterHelper.PATH_MAP).navigation()
            5 -> ARouter.getInstance().build(ARouterHelper.PATH_SETTING).navigation()
            6 -> ARouter.getInstance().build(ARouterHelper.PATH_VOICE_SETTING).navigation()
            7 -> ARouter.getInstance().build(ARouterHelper.PATH_WEATHER).navigation()

        }
    }
}