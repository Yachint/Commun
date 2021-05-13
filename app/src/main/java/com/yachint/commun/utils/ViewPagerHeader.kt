package com.yachint.commun.utils

import android.content.Context
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager.widget.ViewPager

class ViewPagerHeader(
        val context: Context,
        val motionLayout: MotionLayout,
        val viewPager: ViewPager
): ViewPager.OnPageChangeListener {

    init {
        viewPager.addOnPageChangeListener(this)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        val numPages = 2
        motionLayout.progress = (position + positionOffset) / (numPages -1)
    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

}