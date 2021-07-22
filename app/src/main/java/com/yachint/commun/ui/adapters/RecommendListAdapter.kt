package com.yachint.commun.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yachint.commun.databinding.FeedSearchListBinding
import com.yachint.commun.ui.viewholder.RecommendListViewHolder

class RecommendListAdapter(
    val context: Context
): RecyclerView.Adapter<RecommendListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendListViewHolder {
        val binding = FeedSearchListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return RecommendListViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: RecommendListViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = 10
}