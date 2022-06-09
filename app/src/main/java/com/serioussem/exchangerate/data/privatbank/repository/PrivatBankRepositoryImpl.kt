package com.serioussem.exchangerate.data.privatbank.repository

import com.serioussem.exchangerate.data.mappers.DataResultToDomainMapper
import com.serioussem.exchangerate.data.privatbank.datasource.PrivatBankRemoteDataSource
import com.serioussem.exchangerate.domain.core.DomainModelList
import com.serioussem.exchangerate.domain.core.DomainResult
import com.serioussem.exchangerate.domain.privatbank.repository.PrivatBankRepository

class PrivatBankRepositoryImpl(
    private val dataSource: PrivatBankRemoteDataSource,
    private val mapper: DataResultToDomainMapper
) : PrivatBankRepository {
    override suspend fun fetchCurrencyRate(): DomainResult<DomainModelList> =
        mapper.map(dataSource.fetch())
}
