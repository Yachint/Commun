package com.yachint.commun.data.common

import com.yachint.commun.data.model.BaseModel

interface RepositoryListener {
    fun onSuccess(dataModel: BaseModel)
    fun onFailure(t: Throwable)
}