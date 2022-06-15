package com.serioussem.exchangerate.data.monobank.datasource

import com.serioussem.exchangerate.data.core.CurrencyDataResult
import com.serioussem.exchangerate.data.core.ResponseHandler
import com.serioussem.exchangerate.data.monobank.model.MonoBankResponse
import com.serioussem.exchangerate.data.monobank.retrofit.MonoBankService


class MonoBankDataSource(
    private val handler: ResponseHandler,
    private val service: MonoBankService
) {
    suspend fun fetchCurrencyRate(): CurrencyDataResult<List<MonoBankResponse>> =
        handler.fetch() {
            service.fetch()
        }
}