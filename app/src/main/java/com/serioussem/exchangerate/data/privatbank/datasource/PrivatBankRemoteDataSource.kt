package com.serioussem.exchangerate.data.privatbank.datasource

import com.serioussem.exchangerate.data.core.BaseRemoteDataSource
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.core.InternetConnection
import com.serioussem.exchangerate.data.models.DataModelList
import com.serioussem.exchangerate.data.models.DataResult
import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import com.serioussem.exchangerate.data.privatbank.retrofit.PrivatBankService

class PrivatBankRemoteDataSource(
    internetConnection: InternetConnection,
    service: PrivatBankService,
    mapper: BaseMapper<PrivatBankResponse, DataModelList>
) : BaseRemoteDataSource<PrivatBankResponse, DataModelList>(
    internetConnection, service,mapper) {

    override suspend fun fetch(): DataResult<DataModelList> {
        return super.fetch()
    }
}