package com.serioussem.exchangerate.presentation.nbu

import com.serioussem.exchangerate.domain.repository.NbuRepository
import com.serioussem.exchangerate.presentation.core.BaseViewModel
import com.serioussem.exchangerate.presentation.core.UiState
import com.serioussem.exchangerate.utils.AppDispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NbuViewModel(
    repository: NbuRepository,
    dispatchers: AppDispatchers,
    uiState: UiState
) : BaseViewModel(repository = repository, dispatchers = dispatchers) {

    private var mutableNbuResult = MutableStateFlow(uiState)
    val nbuResult = mutableNbuResult.asStateFlow()

    init {
        fetchCurrencyRate()
    }
    override fun fetchCurrencyRate() {
        super.fetch(mutableNbuResult)
    }
}
