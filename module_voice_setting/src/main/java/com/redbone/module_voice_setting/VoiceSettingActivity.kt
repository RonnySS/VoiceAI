package com.redbone.module_voice_setting

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.redbone.lib_base.base.BaseActivity
import com.redbone.lib_base.helper.ARouterHelper
import com.redbone.lib_voice.manager.VoiceManager
import com.redbone.module_voice_setting.databinding.ActivityVoiceSettingBinding

@Route(path = ARouterHelper.PATH_VOICE_SETTING)
class VoiceSettingActivity : BaseActivity<ActivityVoiceSettingBinding>() {

    private val mList:MutableList<String> = ArrayList()
    private var mTtsPeopleIndex:Array<String>? = null
    override fun getTitleText(): String {
        return getString(R.string.app_title_voice_setting)
    }

    override fun initView() {
        binding.barVoiceSpeed.progress = 5
        binding.barVoiceVolume.progress = 5

        binding.barVoiceSpeed.max = 15
        binding.barVoiceVolume.max = 15

        initPeopleView()
        initData()
        binding.barVoiceSpeed.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.barVoiceSpeed.progress = progress
                VoiceManager.setSpeed(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        binding.barVoiceVolume.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.barVoiceVolume.progress = progress
                VoiceManager.setVolume(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })


        binding.btnTest.setOnClickListener {
            VoiceManager.start("你好，我是小爱同学")
        }

    }

    override fun isShowBack(): Boolean {
        return true
    }


    private fun initData(){
        val mTtsPeople = resources.getStringArray(R.array.TTSPeople)
        mTtsPeopleIndex = resources.getStringArray(R.array.TTSPeopleIndex)
        mTtsPeople.forEach {
            mList.add(it)
        }
    }

    private fun initPeopleView(){
        binding.rvVoiceSpeaker.layoutManager = LinearLayoutManager(this)
        val adapter = CommonAdapter(mList)
        adapter.addChildClickViewIds(R.id.speaker_name)
        adapter.setOnItemChildClickListener(object : OnItemChildClickListener {
            override fun onItemChildClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                if(view.id == R.id.speaker_name){
                    mTtsPeopleIndex?.let {
                        VoiceManager.setPeople(it[position])
                    }

                }

            }

        })
        binding.rvVoiceSpeaker.adapter = adapter


    }
}

