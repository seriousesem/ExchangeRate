package com.serioussem.exchangerate.domain.privatbank.repository

import com.serioussem.exchangerate.domain.core.BaseRepository
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel

interface PrivatBankRepository: BaseRepository<CurrencyDomainResult<List<CurrencyRateModel>>> {
    override suspend fun fetchCurrencyRate(): CurrencyDomainResult<List<CurrencyRateModel>>
}