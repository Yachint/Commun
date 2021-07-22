package com.yachint.commun.data.repository

import com.yachint.commun.data.common.RepositoryListener

interface SearchRepository {
    fun fetchSuggestList(repositoryListener: RepositoryListener)
    fun fetchSearchList(repositoryListener: RepositoryListener)
}