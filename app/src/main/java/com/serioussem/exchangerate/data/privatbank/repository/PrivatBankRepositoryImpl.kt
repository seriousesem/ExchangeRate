package com.serioussem.exchangerate.data.privatbank.repository

import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankDataResultToDomainMapper
import com.serioussem.exchangerate.data.privatbank.datasource.PrivatBankDataSource
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.repository.PrivatBankRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*

class PrivatBankRepositoryImpl(
    private val dataSource: PrivatBankDataSource,
    private val mapper: PrivatBankDataResultToDomainMapper,
    private val dispatcher: CoroutineDispatcher
) : PrivatBankRepository {
    override suspend fun fetchCurrencyRate(): Flow<CurrencyDomainResult<List<CurrencyRateModel>>> =
        flow {
            emit(mapper.map(source = dataSource.fetchCurrencyRate()))
        }.onStart {
            emit(CurrencyDomainResult.Loading())
        }.flowOn(dispatcher)
            .catch {
                emit(CurrencyDomainResult.Error(message = it.message.toString()))
            }
}
