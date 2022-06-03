package com.serioussem.exchangerate.presentation.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(): ViewModel() {

    private var pageTitleMutable: MutableLiveData<String> = MutableLiveData<String>()
    val pageTitle: LiveData<String> = pageTitleMutable

    init {
        fetchPageTitle()
    }

    private fun fetchPageTitle() = pageTitle

    fun updatePageTitle(title: String) {
        pageTitleMutable.value = title
    }
}