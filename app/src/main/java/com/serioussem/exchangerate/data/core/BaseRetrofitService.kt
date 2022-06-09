package com.serioussem.exchangerate.data.core

import retrofit2.Response

interface BaseRetrofitService<T> {
    suspend fun fetch(): Response<T>
}