package com.serioussem.exchangerate.presentation.monobank

import androidx.lifecycle.ViewModel
import com.serioussem.exchangerate.domain.monobank.usecase.MonoBankCurrencyRate

class MonoBankViewModel(private val useCase: MonoBankCurrencyRate): ViewModel() {
}