package com.serioussem.exchangerate.data.privatbank.retrofit

import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import retrofit2.Response
import retrofit2.http.GET

interface PrivatBankService{

    @GET("pubinfo?json&exchange&coursid=5")
    suspend fun fetch(): Response<PrivatBankResponse>
}