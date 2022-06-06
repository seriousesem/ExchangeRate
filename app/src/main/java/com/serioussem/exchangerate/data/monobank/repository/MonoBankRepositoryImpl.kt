package com.serioussem.exchangerate.data.monobank.repository

import com.serioussem.exchangerate.domain.core.DomainModel
import com.serioussem.exchangerate.domain.core.DomainResult
import com.serioussem.exchangerate.domain.monobank.repository.MonoBankRepository

class MonoBankRepositoryImpl: MonoBankRepository {
    override suspend fun fetchCurrencyRate(): DomainResult<DomainModel> {
        return super.fetchCurrencyRate()
    }
}