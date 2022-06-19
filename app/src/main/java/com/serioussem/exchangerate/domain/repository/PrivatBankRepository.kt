package com.serioussem.exchangerate.domain.repository

import com.serioussem.exchangerate.domain.core.BaseRepository
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import kotlinx.coroutines.flow.Flow

interface PrivatBankRepository: BaseRepository<CurrencyDomainResult<List<CurrencyRateModel>>> {
    override suspend fun fetchCurrencyRate(): Flow<CurrencyDomainResult<List<CurrencyRateModel>>>
}