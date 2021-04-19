package com.yachint.commun.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yachint.commun.databinding.FeedPostsLayoutBinding
import com.yachint.commun.ui.viewholder.FeedViewHolder

class FeedAdapter(
    val context: Context
): RecyclerView.Adapter<FeedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding = FeedPostsLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return FeedViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = 10
}