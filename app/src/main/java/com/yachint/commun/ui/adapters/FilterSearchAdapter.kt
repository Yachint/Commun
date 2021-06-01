package com.yachint.commun.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yachint.commun.data.model.FilterOption
import com.yachint.commun.databinding.FilterSearchItemLayoutBinding
import com.yachint.commun.ui.fragment.ExploreFragment
import com.yachint.commun.ui.viewholder.FilterSearchViewHolder

class FilterSearchAdapter(
    val context: Context,
    var filterOptions: ArrayList<FilterOption>,
    val parentFragment: ExploreFragment
): RecyclerView.Adapter<FilterSearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterSearchViewHolder {
        val binding = FilterSearchItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return FilterSearchViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: FilterSearchViewHolder, position: Int) {
        holder.bind(filterOptions[position], position, parentFragment)
    }

    override fun getItemCount(): Int  = filterOptions.size

}