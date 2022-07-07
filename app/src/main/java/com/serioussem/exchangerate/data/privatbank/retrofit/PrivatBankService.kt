package com.serioussem.exchangerate.data.privatbank.retrofit

import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import retrofit2.Response
import retrofit2.http.GET


interface PrivatBankService {

    companion object {
        private const val PRIVAT_BANK_END_POINT = "pubinfo?json&exchange&coursid=5"
    }
    @GET(PRIVAT_BANK_END_POINT)
    suspend fun fetch(): Response<List<PrivatBankResponse>>
}