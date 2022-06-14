package com.serioussem.exchangerate.data.monobank.repository

import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.monobank.repository.MonoBankRepository

class MonoBankRepositoryImpl: MonoBankRepository {
    override suspend fun fetchCurrencyRate(): CurrencyDomainResult<CurrencyRateModel> {
        return super.fetchCurrencyRate()
    }
}