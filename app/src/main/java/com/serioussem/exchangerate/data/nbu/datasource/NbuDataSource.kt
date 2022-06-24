package com.serioussem.exchangerate.data.nbu.datasource

import com.serioussem.exchangerate.data.core.CurrencyDataResult
import com.serioussem.exchangerate.data.core.ResponseHandler
import com.serioussem.exchangerate.data.nbu.model.NbuResponse
import com.serioussem.exchangerate.data.nbu.retrofit.NbuService

class NbuDataSource(
    private val handler: ResponseHandler,
    private val service: NbuService
) {
    suspend fun fetchCurrencyRate(): CurrencyDataResult<List<NbuResponse>> =
        handler.fetch() {
            service.fetch()
        }
}