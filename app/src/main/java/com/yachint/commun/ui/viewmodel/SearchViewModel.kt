package com.yachint.commun.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yachint.commun.data.common.RepositoryListener
import com.yachint.commun.data.model.BaseModel
import com.yachint.commun.data.model.search.SearchListModel
import com.yachint.commun.data.model.search.SuggestModel
import com.yachint.commun.data.retrofit.RetroSearchRepository

class SearchViewModel(
    private val retroSearchRepo: RetroSearchRepository
): ViewModel(), RepositoryListener {

    var isLoaded: MutableLiveData<Boolean> = MutableLiveData(false)
    private var ping: MutableLiveData<Int> = MutableLiveData(0)

    fun getSuggestList() = retroSearchRepo.fetchSuggestList(this)

    fun getSearchList() = retroSearchRepo.fetchSearchList(this)

    override fun onSuccess(dataModel: BaseModel) {
        when(dataModel) {
            is SuggestModel -> {
                ping.value = ping.value?.plus(1)
                if(ping.value == 2){
                    isLoaded.value = true
                }
            }

            is SearchListModel -> {
                ping.value = ping.value?.plus(1)
                if(ping.value == 2){
                    isLoaded.value = true
                }
            }
        }
    }

    override fun onFailure(t: Throwable) {

    }

}