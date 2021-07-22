package com.yachint.commun.ui.adapters.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.yachint.commun.R

class SuggestViewPagerAdapter(
    val context: Context
): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(
            R.layout.pager_suggest_layout, container, false
        )

        container.addView(view, 0)
        return view
    }

    override fun getCount(): Int = 5

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}