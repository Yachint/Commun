package com.yachint.commun.ui.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yachint.commun.data.retrofit.RetroSearchRepository
import com.yachint.commun.ui.viewmodel.SearchViewModel

@Suppress("UNCHECKED_CAST")

class SearchViewModelFactory constructor(
    private val searchRepository: RetroSearchRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(searchRepository) as T
    }
}