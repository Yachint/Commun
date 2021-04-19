package com.yachint.commun.ui.fragment.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.yachint.commun.R
import com.yachint.commun.databinding.FragmentPersonalisedFeedBinding
import com.yachint.commun.ui.adapters.FeedAdapter

class PersonalisedFeedFragment : Fragment() {

    lateinit var binding: FragmentPersonalisedFeedBinding
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_personalised_feed, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(requireContext())
        binding.rvPersFeed.layoutManager = layoutManager
        adapter = FeedAdapter(requireContext())
        binding.rvPersFeed.adapter = adapter
    }
}