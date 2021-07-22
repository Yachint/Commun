package com.yachint.commun.ui.modules

import com.yachint.commun.data.Database
import com.yachint.commun.data.dao.SearchDao
import com.yachint.commun.data.retrofit.RetroSearchRepository
import com.yachint.commun.ui.viewmodelfactory.SearchViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class VMFSearchModule {
    companion object {
        @Provides
        fun provideSearchDao(): SearchDao = Database.getInstance().searchDao

        @Provides
        fun provideSearchRepository(searchDao: SearchDao):
                RetroSearchRepository = RetroSearchRepository.getInstance(searchDao)

        @Provides
        fun provideSearchViewModelFactory(retroSearchRepository: RetroSearchRepository):
                SearchViewModelFactory = SearchViewModelFactory(retroSearchRepository)
    }

}