package com.serioussem.exchangerate.data.privatbank.datasource

import com.serioussem.exchangerate.data.core.ResponseHandler
import com.serioussem.exchangerate.data.core.CurrencyDataResult
import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import com.serioussem.exchangerate.data.privatbank.retrofit.PrivatBankService

class PrivatBankDataSource(
    private val handler: ResponseHandler,
    private val service: PrivatBankService
) {
    suspend fun fetchCurrencyRate(): CurrencyDataResult<List<PrivatBankResponse>> =
        handler.fetch() {
            service.fetch()
        }
}