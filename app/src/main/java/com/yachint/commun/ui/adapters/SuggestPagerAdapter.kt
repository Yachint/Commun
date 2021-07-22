package com.yachint.commun.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yachint.commun.databinding.FeedPostsLayoutBinding
import com.yachint.commun.databinding.PagerSuggestLayoutBinding
import com.yachint.commun.ui.viewholder.SuggestPagerViewHolder

class SuggestPagerAdapter(
    val context: Context
): RecyclerView.Adapter<SuggestPagerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestPagerViewHolder {
        val binding = PagerSuggestLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return SuggestPagerViewHolder(context, binding)
    }

    override fun onBindViewHolder(holder: SuggestPagerViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = 5

}