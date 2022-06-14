package com.serioussem.exchangerate.presentation.privatbank

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.privatbank.usecase.PrivatBankCurrencyRate
import com.serioussem.exchangerate.presentation.core.AppDispatchers

class PrivatBankViewModel(
    private val useCase: PrivatBankCurrencyRate,
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
            mutableData.postValue(useCase.fetchCurrencyRate())
        }
    }

}