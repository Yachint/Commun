package com.yachint.commun.ui.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.yachint.commun.databinding.PagerSuggestLayoutBinding
import hari.bounceview.BounceView

class SuggestPagerViewHolder(
    val context: Context,
    val binding: PagerSuggestLayoutBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int){
        BounceView.addAnimTo(binding.followBtn)
    }
}