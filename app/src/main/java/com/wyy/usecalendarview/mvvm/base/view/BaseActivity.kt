package com.wyy.usecalendarview.mvvm.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wyy.usecalendarview.mvvm.base.UtilMvvm

/**
 * Copyright (C), 2015-2021, 海南双猴科技有限公司
 * @Description: 暂无
 * @Author: Yingyan Wu
 * @CreateDate: 2021/1/21 10:23
 * History:
 * @Author: 暂无
 * @Date: 暂无
 * @Description: 暂无
 */
abstract class BaseActivity<VM : ViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var mViewModel: VM
    protected lateinit var mDataBinding: DB

    open fun initView() {
        initDataObserver()
    }

    open fun initData() {}

    open fun initDataObserver() {}

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mDataBinding.lifecycleOwner = this
        mViewModel = ViewModelProvider(this).get(UtilMvvm.getClass(this))
        initView()
        initData()
    }
}