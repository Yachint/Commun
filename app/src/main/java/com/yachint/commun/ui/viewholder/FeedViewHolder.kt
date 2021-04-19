package com.yachint.commun.ui.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.yachint.commun.databinding.FeedPostsLayoutBinding
import hari.bounceview.BounceView

class FeedViewHolder(
    val binding: FeedPostsLayoutBinding,
    val context: Context
): RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int){
        BounceView.addAnimTo(binding.btnComment)
        BounceView.addAnimTo(binding.btnCommunityHeader)
        BounceView.addAnimTo(binding.btnDown)
        BounceView.addAnimTo(binding.btnProfilePicture)
        BounceView.addAnimTo(binding.btnShare)
        BounceView.addAnimTo(binding.btnUpVote)
        BounceView.addAnimTo(binding.btnUserId)
    }
}