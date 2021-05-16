package com.wyy.usecalendarview.mvvm.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
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
abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : Fragment() {
    protected lateinit var mViewModel: VM

    protected lateinit var mDataBinding: DB

    open fun initView() {
        initDataObserver()
    }

    open fun initData() {}

    open fun initDataObserver() {}

    open fun reLoad() = initData()

    abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mDataBinding.lifecycleOwner = this
        return mDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mViewModel = ViewModelProvider(this).get(UtilMvvm.getClass(this))
        initView()
        initData()
    }
}