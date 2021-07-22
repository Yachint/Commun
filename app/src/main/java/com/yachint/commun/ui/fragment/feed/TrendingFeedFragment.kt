package com.yachint.commun.ui.fragment.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.yachint.commun.R
import com.yachint.commun.databinding.FragmentTrendingFeedBinding
import com.yachint.commun.ui.adapters.FeedAdapter


class TrendingFeedFragment : Fragment() {

    lateinit var binding: FragmentTrendingFeedBinding
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_trending_feed, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(requireContext())
        binding.rvTrendingFeed.layoutManager = layoutManager
        adapter = FeedAdapter(requireContext())
        binding.rvTrendingFeed.adapter = adapter
    }

}