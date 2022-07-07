package com.serioussem.exchangerate.presentation.monobank

import com.serioussem.exchangerate.domain.repository.MonoBankRepository
import com.serioussem.exchangerate.presentation.core.BaseViewModel
import com.serioussem.exchangerate.presentation.core.UiState
import com.serioussem.exchangerate.utils.AppDispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MonoBankViewModel(
    repository: MonoBankRepository,
    dispatchers: AppDispatchers,
    uiState: UiState
) : BaseViewModel(repository = repository, dispatchers = dispatchers) {

    private var mutableMonoBankResult = MutableStateFlow(uiState)
    val monoBankResult = mutableMonoBankResult.asStateFlow()

    init {
        fetchCurrencyRate()
    }

    override fun fetchCurrencyRate() {
        super.fetch(mutableMonoBankResult)
    }
}