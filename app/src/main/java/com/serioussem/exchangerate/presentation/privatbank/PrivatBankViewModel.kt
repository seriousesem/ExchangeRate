package com.serioussem.exchangerate.presentation.privatbank

import androidx.lifecycle.ViewModel
import com.serioussem.exchangerate.domain.privatbank.usecase.PrivatBankCurrencyRate

class PrivatBankViewModel(private val useCase: PrivatBankCurrencyRate): ViewModel() {

    suspend fun fetchCurrencyRate() = useCase.fetchCurrencyRate()
}