package com.serioussem.exchangerate.presentation.monobank

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.repository.MonoBankRepository
import com.serioussem.exchangerate.presentation.core.UiState
import com.serioussem.exchangerate.utils.AppDispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update

class MonoBankViewModel(
    private val repository: MonoBankRepository,
    private val dispatchers: AppDispatchers,
    uiState: UiState
) : ViewModel() {

    private val mutableUiState = MutableStateFlow(uiState)
    val uiState = mutableUiState.asStateFlow()

    init {
        fetchCurrencyRate()
    }

    private fun fetchCurrencyRate() {
        dispatchers.launchBackground(viewModelScope) {
            repository.fetchCurrencyRate().collect {result ->
                when(result){
                    is CurrencyDomainResult.Loading -> mutableUiState.update {
                        it.copy(loading = true)
                    }
                    is CurrencyDomainResult.Success -> mutableUiState.update{
                        it.copy(currencyRateList = result.data!!)
                    }
                    is CurrencyDomainResult.Error -> mutableUiState.update {
                        it.copy(errorMessage = result.message)
                    }
                    else -> throw IllegalStateException()
                }
            }
        }
    }
}