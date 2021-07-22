package com.yachint.commun.ui.viewholder

import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tencent.mmkv.MMKV
import com.yachint.commun.R
import com.yachint.commun.data.model.FilterOption
import com.yachint.commun.databinding.FilterSearchItemLayoutBinding
import com.yachint.commun.ui.fragment.ExploreFragment
import hari.bounceview.BounceView

class FilterSearchViewHolder(
    val binding: FilterSearchItemLayoutBinding,
    val context: Context
): RecyclerView.ViewHolder(binding.root) {

    fun bind(filterOption: FilterOption, position: Int, parentFragment: ExploreFragment){

        binding.filterText.text = filterOption.optionName
        if(filterOption.isSelected){
            binding.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorBlue))
        } else {
            if(MMKV.defaultMMKV()?.decodeString("theme") == "dark"){
                binding.cardView.setCardBackgroundColor(Color.parseColor("#303030"))
            } else {
                binding.cardView.setCardBackgroundColor(Color.parseColor("#f5f5f5"))
            }
        }

        binding.rippleView.setOnClickListener {
            parentFragment.handleFilterClick(position)
        }
    }
}