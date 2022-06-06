package com.serioussem.exchangerate.domain.monobank.usecase

import com.serioussem.exchangerate.domain.core.BaseUseCase
import com.serioussem.exchangerate.domain.core.DomainModel
import com.serioussem.exchangerate.domain.core.DomainResult
import com.serioussem.exchangerate.domain.monobank.repository.MonoBankRepository

class MonoBankCurrencyRate(private val repository: MonoBankRepository) :
    BaseUseCase<DomainResult<DomainModel>> {

    override suspend fun fetchCurrencyRate() = repository.fetchCurrencyRate()
}