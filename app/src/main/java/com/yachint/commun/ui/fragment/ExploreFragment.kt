package com.yachint.commun.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yachint.commun.R
import com.yachint.commun.databinding.FragmentExploreBinding
import com.yachint.commun.ui.adapters.SuggestPagerAdapter
import com.yachint.commun.utils.SlidePageTransformer
import com.yachint.commun.utils.VerticalItemDecorator
import com.yachint.commun.utils.ViewPagerEventHandler

class ExploreFragment : Fragment() {

    lateinit var binding: FragmentExploreBinding
    lateinit var suggestAdapter: SuggestPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_explore, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val verticalOffset = requireContext().resources.getDimension(R.dimen.viewpager_current_item_vertical_margin).toInt()
//        binding.pagerControl.apply {
//            count = 5
//            selection = 1
//        }
        val pagerHandler = ViewPagerEventHandler(binding.suggestViewPager)

        suggestAdapter = SuggestPagerAdapter(requireContext())
        binding.suggestViewPager.apply {
            adapter = suggestAdapter
            offscreenPageLimit = 3
            setPageTransformer(SlidePageTransformer(3, verticalOffset))
            addItemDecoration(VerticalItemDecorator(verticalOffset, pagerHandler))
        }

        binding.pagerControl.setViewPager2(binding.suggestViewPager)
    }

}