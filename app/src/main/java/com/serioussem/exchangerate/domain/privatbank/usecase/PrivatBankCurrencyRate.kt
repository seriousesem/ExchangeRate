package com.serioussem.exchangerate.domain.privatbank.usecase

import com.serioussem.exchangerate.domain.core.BaseUseCase
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.privatbank.repository.PrivatBankRepository

class PrivatBankCurrencyRate(private val repository: PrivatBankRepository) :
    BaseUseCase<CurrencyDomainResult<List<CurrencyRateModel>>> {

    override suspend fun fetchCurrencyRate() = repository.fetchCurrencyRate()
}