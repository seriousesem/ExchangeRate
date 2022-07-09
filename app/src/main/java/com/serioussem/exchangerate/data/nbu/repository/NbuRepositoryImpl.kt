package com.serioussem.exchangerate.data.nbu.repository

import com.serioussem.exchangerate.data.nbu.datasource.NbuDataSource
import com.serioussem.exchangerate.data.nbu.mappers.NbuDataResultToDomainMapper
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.repository.NbuRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*

class NbuRepositoryImpl(
    private val dataSource: NbuDataSource,
    private val mapper: NbuDataResultToDomainMapper,
    private val dispatcher: CoroutineDispatcher
) : NbuRepository {
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