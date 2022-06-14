package com.serioussem.exchangerate.data.privatbank.retrofit

import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import retrofit2.Response
import retrofit2.http.GET


interface PrivatBankService {

    companion object {
        private const val PRIVAT_BANK_FIRST_ENDPOINT = "pubinfo?json&exchange&coursid=5"
    }
    @GET(PRIVAT_BANK_FIRST_ENDPOINT)
    suspend fun fetchFirstResponse(): Response<List<PrivatBankResponse>>
}