package com.yachint.commun.utils

import android.content.Context
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager.widget.ViewPager

class ViewPagerHeader(
        val context: Context,
        val headerMotionLayout: MotionLayout,
        val viewPager: ViewPager
): ViewPager.OnPageChangeListener {

    init {
        viewPager.addOnPageChangeListener(this)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        val numPages = 2
        headerMotionLayout.progress = (position + positionOffset) / (numPages -1)
    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

}