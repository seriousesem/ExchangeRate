package com.serioussem.exchangerate.data.monobank.repository

import com.serioussem.exchangerate.data.monobank.datasource.MonoBankDataSource
import com.serioussem.exchangerate.data.monobank.mappers.MonoBankDataResultToDomainMapper
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.repository.MonoBankRepository

class MonoBankRepositoryImpl(
    private val dataSource: MonoBankDataSource,
    private val mapper: MonoBankDataResultToDomainMapper
): MonoBankRepository {
    override suspend fun fetchCurrencyRate(): CurrencyDomainResult<List<CurrencyRateModel>> =
        mapper.map(source = dataSource.fetchCurrencyRate())
}