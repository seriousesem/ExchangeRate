package com.serioussem.exchangerate.domain.monobank.usecase

import com.serioussem.exchangerate.domain.core.BaseUseCase
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.monobank.repository.MonoBankRepository

class MonoBankCurrencyRate(private val repository: MonoBankRepository) :
    BaseUseCase<CurrencyDomainResult<CurrencyRateModel>> {

    override suspend fun fetchCurrencyRate() = repository.fetchCurrencyRate()
}