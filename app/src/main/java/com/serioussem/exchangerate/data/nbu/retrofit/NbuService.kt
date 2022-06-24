package com.serioussem.exchangerate.data.nbu.retrofit

import com.serioussem.exchangerate.data.nbu.model.NbuResponse
import retrofit2.Response
import retrofit2.http.GET

interface NbuService {

    companion object {
        private const val NBU_ENDPOINT = "NBUStatService/v1/statdirectory/exchange?json"
    }

    @GET(NBU_ENDPOINT)
    suspend fun fetch(): Response<List<NbuResponse>>
}