package com.serioussem.exchangerate.presentation.privatbank

import com.serioussem.exchangerate.domain.repository.PrivatBankRepository
import com.serioussem.exchangerate.presentation.core.BaseViewModel
import com.serioussem.exchangerate.presentation.core.UiState
import com.serioussem.exchangerate.utils.AppDispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class PrivatBankViewModel(
    repository: PrivatBankRepository,
    dispatchers: AppDispatchers,
    uiState: UiState
) : BaseViewModel(repository = repository, dispatchers = dispatchers) {

    private var mutableResult = MutableStateFlow(uiState)
    val result = mutableResult.asStateFlow()

    init {
        fetchCurrencyRate()
    }

    fun fetchCurrencyRate() {
        super.fetch(mutableResult)
    }

}