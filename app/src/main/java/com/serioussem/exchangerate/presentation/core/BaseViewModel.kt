package com.serioussem.exchangerate.presentation.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serioussem.exchangerate.domain.core.BaseRepository
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.utils.AppDispatchers
import com.serioussem.exchangerate.utils.ResourceProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update

abstract class BaseViewModel(
    private val repository: BaseRepository<CurrencyDomainResult<List<CurrencyRateModel>>>,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    fun fetch(resultData: MutableStateFlow<UiState>) {
        dispatchers.launchBackground(viewModelScope) {
            repository.fetchCurrencyRate().collect { result ->
                when (result) {
                    is CurrencyDomainResult.Loading -> resultData.update {
                        it.copy(loading = true)
                    }
                    is CurrencyDomainResult.Success -> resultData.update {
                        it.copy(currencyRateList = result.data!!)
                    }
                    is CurrencyDomainResult.Error -> resultData.update {
                        it.copy(errorMessage = result.message)
                    }
                    else -> throw IllegalStateException()
                }
            }
        }
    }

    open fun fetchCurrencyRate() {}

}