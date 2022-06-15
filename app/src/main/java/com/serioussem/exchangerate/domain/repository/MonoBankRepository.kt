package com.serioussem.exchangerate.domain.repository

import com.serioussem.exchangerate.domain.core.BaseRepository
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult

interface MonoBankRepository: BaseRepository<CurrencyDomainResult<List<CurrencyRateModel>>> {
    override suspend fun fetchCurrencyRate(): CurrencyDomainResult<List<CurrencyRateModel>>
}