package com.serioussem.exchangerate.data.privatbank.datasource.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface PrivatBankService {

    @GET("pubinfo?json&exchange&coursid=5")
    suspend fun fetchCurrencyRate(): Response<PrivatBankModelList>
}