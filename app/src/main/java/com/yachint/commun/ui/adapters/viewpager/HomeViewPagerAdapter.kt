package com.yachint.commun.ui.adapters.viewpager

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.yachint.commun.ui.fragment.feed.PersonalisedFeedFragment
import com.yachint.commun.ui.fragment.feed.TrendingFeedFragment

class HomeViewPagerAdapter(
    val context: Context,
    fm: FragmentManager,
    val personalisedFeedFragment: PersonalisedFeedFragment,
    val trendingFeedFragment: TrendingFeedFragment
): FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                personalisedFeedFragment
            }

            1 -> {
                trendingFeedFragment
            }

            else -> {
                personalisedFeedFragment
            }
        }
    }

}