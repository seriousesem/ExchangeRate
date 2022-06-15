package com.serioussem.exchangerate.data.monobank.retrofit

import com.serioussem.exchangerate.data.monobank.model.MonoBankResponse
import retrofit2.Response
import retrofit2.http.GET

interface MonoBankService {

    companion object {
        private const val MONO_BANK_ENDPOINT = "bank/currency"
    }

    @GET(MONO_BANK_ENDPOINT)
    suspend fun fetch(): Response<List<MonoBankResponse>>
}