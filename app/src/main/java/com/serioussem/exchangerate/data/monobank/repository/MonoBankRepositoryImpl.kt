package com.serioussem.exchangerate.data.monobank.repository

import com.serioussem.exchangerate.data.monobank.datasource.MonoBankDataSource
import com.serioussem.exchangerate.data.monobank.mappers.MonoBankDataResultToDomainMapper
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.repository.MonoBankRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*

class MonoBankRepositoryImpl(
    private val dataSource: MonoBankDataSource,
    private val mapper: MonoBankDataResultToDomainMapper,
    private val dispatcher: CoroutineDispatcher
): MonoBankRepository {
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