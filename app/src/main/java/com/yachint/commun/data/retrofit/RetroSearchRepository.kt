package com.yachint.commun.data.retrofit

import android.os.Handler
import android.os.Looper
import com.yachint.commun.data.common.RepositoryListener
import com.yachint.commun.data.dao.SearchDao
import com.yachint.commun.data.model.search.SearchListModel
import com.yachint.commun.data.model.search.SuggestModel
import com.yachint.commun.data.repository.SearchRepository

class RetroSearchRepository private constructor(
    private val searchDao: SearchDao
): SearchRepository {
    companion object {
        @Volatile private var instance :RetroSearchRepository? = null

        fun getInstance(searchDao: SearchDao) =
            instance ?: synchronized(this) {
                instance ?: RetroSearchRepository(searchDao).also { instance = it }
            }
    }

    override fun fetchSuggestList(repositoryListener: RepositoryListener) {
        //Mock API Call
        Handler(Looper.getMainLooper()).postDelayed({
            searchDao.addSuggestList()
            repositoryListener.onSuccess(SuggestModel())
        }, 1500)
    }

    override fun fetchSearchList(repositoryListener: RepositoryListener) {
        Handler(Looper.getMainLooper()).postDelayed({
            //Mock API Call
            searchDao.addSearchList()
            repositoryListener.onSuccess(SearchListModel())
        }, 1500)
    }


}