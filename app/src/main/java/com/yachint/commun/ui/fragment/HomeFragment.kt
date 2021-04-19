package com.yachint.commun.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yachint.commun.R
import com.yachint.commun.databinding.FragmentHomeBinding
import com.yachint.commun.ui.adapters.viewpager.HomeViewPagerAdapter
import com.yachint.commun.ui.fragment.feed.PersonalisedFeedFragment
import com.yachint.commun.ui.fragment.feed.TrendingFeedFragment

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val personalisedFeedFragment = PersonalisedFeedFragment()
    val trendingFeedFragment = TrendingFeedFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPagerHome.adapter = HomeViewPagerAdapter(
            requireContext(),
            requireFragmentManager(),
            personalisedFeedFragment,
            trendingFeedFragment
        )
    }

}