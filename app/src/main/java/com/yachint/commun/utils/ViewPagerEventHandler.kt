package com.yachint.commun.utils

import androidx.viewpager2.widget.ViewPager2

class ViewPagerEventHandler(
    val viewPager: ViewPager2,
    val toggleBalloon: () -> Unit
): ViewPager2.OnPageChangeCallback() {
    private var index: Int = 0
    private var isBalloonToggled = false

    init {
        viewPager.registerOnPageChangeCallback(this)

    }

    override fun onPageSelected(position: Int) {
        index = position
        if(index == 1 && !isBalloonToggled){
            toggleBalloon()
            isBalloonToggled = true
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    public fun currentPosition(): Int = index

}