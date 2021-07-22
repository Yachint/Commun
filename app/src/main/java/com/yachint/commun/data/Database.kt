package com.yachint.commun.data

import com.yachint.commun.data.dao.SearchDao

class Database private constructor(){

    val searchDao = SearchDao()

    companion object {
        @Volatile private var instance: Database? = null

        fun getInstance() =
            instance ?: synchronized(this){
                instance ?: Database().also { instance = it }
            }
    }
}