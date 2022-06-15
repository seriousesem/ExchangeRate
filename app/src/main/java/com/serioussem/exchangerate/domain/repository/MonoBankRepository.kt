package com.serioussem.exchangerate.domain.repository

import com.serioussem.exchangerate.domain.core.BaseRepository
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult

interface MonoBankRepository: BaseRepository<CurrencyDomainResult<CurrencyRateModel>> {
    override suspend fun fetchCurrencyRate(): CurrencyDomainResult<CurrencyRateModel> {
        TODO("Not yet implemented")
    }
}