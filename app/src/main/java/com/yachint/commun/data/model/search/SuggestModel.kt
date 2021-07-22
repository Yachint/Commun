package com.yachint.commun.data.model.search

import com.yachint.commun.data.model.BaseModel
import java.io.Serializable

data class SuggestModel(
    val title: String = "",
    val image: String = "",
    val posts: Int = 0,
    val follows: Int = 0,
    val banner: String = ""
): BaseModel, Serializable