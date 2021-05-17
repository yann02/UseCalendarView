package com.wyy.usecalendarview

import android.util.Log
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.CalendarView
import com.wyy.usecalendarview.databinding.ActivityMainBinding
import com.wyy.usecalendarview.mvvm.base.view.BaseActivity

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(), CalendarView.OnMonthChangeListener,
    CalendarView.OnCalendarSelectListener {
    override fun getLayoutId() = R.layout.activity_main
    override fun initView() {
        super.initView()
        setSupportActionBar(mDataBinding.toolbar)
        //  监听日历控件
        mDataBinding.cvCalendar.setOnMonthChangeListener(this)
        mDataBinding.cvCalendar.setOnCalendarSelectListener(this)
        //  监听按钮点击事件
        mDataBinding.btnLastYear.setOnClickListener {
            mDataBinding.cvCalendar.monthViewPager.apply {
                currentItem -= 12
            }
        }
        mDataBinding.btnNextYear.setOnClickListener {
            mDataBinding.cvCalendar.monthViewPager.apply {
                currentItem += 12
            }
        }
        mDataBinding.btnLastMonth.setOnClickListener {
            mDataBinding.cvCalendar.scrollToPre()
        }
        mDataBinding.btnNextMonth.setOnClickListener {
            mDataBinding.cvCalendar.scrollToNext()
        }
        mDataBinding.btnToday.setOnClickListener {
            mDataBinding.cvCalendar.scrollToCurrent()
        }
        supportActionBar?.title = getString(R.string.title, mDataBinding.cvCalendar.curYear, mDataBinding.cvCalendar.curMonth)
    }

    override fun onMonthChange(year: Int, month: Int) {
        supportActionBar?.title = getString(R.string.title, year, month)
    }

    /**
     * 没用到
     */
    override fun onCalendarOutOfRange(calendar: Calendar?) {}

    /**
     * 用户选择的监听
     */
    override fun onCalendarSelect(calendar: Calendar?, isClick: Boolean) {
        Log.d(
            "wyy",
            "Selector year is ${calendar?.year},month is ${calendar?.month},day is ${calendar?.day} and isClick is $isClick"
        )
    }
}