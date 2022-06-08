package com.serioussem.exchangerate.data.privatbank.datasource

import com.serioussem.exchangerate.data.core.BaseDataSource
import com.serioussem.exchangerate.data.core.ResponseHandler
import com.serioussem.exchangerate.data.models.DataModelList
import com.serioussem.exchangerate.data.models.DataResult
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankResponseToDataListMapper
import com.serioussem.exchangerate.data.privatbank.retrofit.PrivatBankService

class PrivatBankDataSource(
    private val service: PrivatBankService,
    private val mapper: PrivatBankResponseToDataListMapper,
    private val handler: ResponseHandler
) : BaseDataSource<DataResult<DataModelList>> {
    override suspend fun fetch(): DataResult<DataModelList> =
        handler.handleResponse {
            service.fetchCurrencyRate()
        }
}