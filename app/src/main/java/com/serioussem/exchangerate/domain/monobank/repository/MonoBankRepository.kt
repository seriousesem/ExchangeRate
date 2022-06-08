package com.serioussem.exchangerate.domain.monobank.repository

import com.serioussem.exchangerate.domain.core.BaseRepository
import com.serioussem.exchangerate.domain.core.DomainModel
import com.serioussem.exchangerate.domain.core.DomainResult

interface MonoBankRepository: BaseRepository<DomainResult<DomainModel>> {
    override suspend fun fetchCurrencyRate(): DomainResult<DomainModel> {
        TODO("Not yet implemented")
    }
}