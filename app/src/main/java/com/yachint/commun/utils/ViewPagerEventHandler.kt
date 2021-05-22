package com.yachint.commun.utils

import androidx.viewpager2.widget.ViewPager2

class ViewPagerEventHandler(
    val viewPager: ViewPager2
): ViewPager2.OnPageChangeCallback() {
    private var index: Int = 0

    init {
        viewPager.registerOnPageChangeCallback(this)

    }

    override fun onPageSelected(position: Int) {
        index = position
    }

    public fun currentPosition(): Int = index

}