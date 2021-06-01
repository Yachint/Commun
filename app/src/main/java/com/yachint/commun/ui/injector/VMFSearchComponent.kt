package com.yachint.commun.ui.injector

import com.yachint.commun.ui.modules.VMFSearchModule
import com.yachint.commun.ui.viewmodelfactory.SearchViewModelFactory
import dagger.Component


@Component (modules = [VMFSearchModule::class])
interface VMFSearchComponent {

    fun getViewModelFactory(): SearchViewModelFactory

}