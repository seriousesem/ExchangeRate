package com.serioussem.exchangerate.data.privatbank.retrofit

import com.serioussem.exchangerate.data.core.BaseRetrofitService
import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import retrofit2.Response
import retrofit2.http.GET

interface PrivatBankService: BaseRetrofitService<PrivatBankResponse> {

    @GET("pubinfo?json&exchange&coursid=5")
    override suspend fun fetch(): Response<PrivatBankResponse>
}