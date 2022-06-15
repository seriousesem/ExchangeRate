package com.serioussem.exchangerate.presentation.privatbank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.repository.PrivatBankRepository
import com.serioussem.exchangerate.presentation.core.AppDispatchers

class PrivatBankViewModel(
    private val repository: PrivatBankRepository,
    private val dispatchers: AppDispatchers
) : ViewModel() {
    private var mutableData =
        MutableLiveData<CurrencyDomainResult<List<CurrencyRateModel>>>(CurrencyDomainResult.Init())

    val data: LiveData<CurrencyDomainResult<List<CurrencyRateModel>>> = mutableData

    init {
        fetchCurrencyRate()
    }


    private fun fetchCurrencyRate() {
//        mutableData.value = DomainResult.Loading()
        dispatchers.launchBackground(viewModelScope){
            mutableData.postValue(repository.fetchCurrencyRate())
        }
    }

}