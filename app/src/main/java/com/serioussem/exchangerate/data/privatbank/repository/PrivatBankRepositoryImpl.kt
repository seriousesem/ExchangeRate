package com.serioussem.exchangerate.data.privatbank.repository

import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankDataResultToDomainMapper
import com.serioussem.exchangerate.data.privatbank.datasource.PrivatBankDataSource
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.privatbank.repository.PrivatBankRepository

class PrivatBankRepositoryImpl(
    private val dataSource: PrivatBankDataSource,
    private val mapper: PrivatBankDataResultToDomainMapper
) : PrivatBankRepository {
    override suspend fun fetchCurrencyRate(): CurrencyDomainResult<List<CurrencyRateModel>> =
       mapper.map(source = dataSource.fetchFirstCurrencyResult())
}
