package com.serioussem.exchangerate.presentation.privatbank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serioussem.exchangerate.domain.core.DomainModel
import com.serioussem.exchangerate.domain.core.DomainModelList
import com.serioussem.exchangerate.domain.core.DomainResult
import com.serioussem.exchangerate.domain.privatbank.usecase.PrivatBankCurrencyRate
import com.serioussem.exchangerate.presentation.core.AppDispatchers

class PrivatBankViewModel(
    private val useCase: PrivatBankCurrencyRate,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    init {
        fetchCurrencyRate()
    }

    private var mutableData =
        MutableLiveData<DomainResult<DomainModelList>>(DomainResult.Init())

    val data: LiveData<DomainResult<DomainModelList>> = mutableData

    private fun fetchCurrencyRate() {
//        mutableData.value = DomainResult.Loading()
        dispatchers.launchBackground(viewModelScope){
            mutableData.postValue(useCase.fetchCurrencyRate())
        }
    }

}