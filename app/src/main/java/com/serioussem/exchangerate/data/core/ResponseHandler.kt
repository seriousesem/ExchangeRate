package com.serioussem.exchangerate.data.core

import com.serioussem.exchangerate.data.models.DataResult
import retrofit2.Response

interface ResponseHandler {
    suspend fun <T> handleResponse(apiRequest: suspend () -> Response<T>): DataResult<T>

    class Base(private val internetConnection: InternetConnection) : ResponseHandler {
        override suspend fun <T> handleResponse(apiRequest: suspend () -> Response<T>): DataResult<T> {
            if (internetConnection.isConnected()) {
                try {
                    val response = apiRequest()
                    val body = response.body()
                    if (response.isSuccessful && body != null) {
                        return DataResult.Success(body)
                    }
                    return DataResult.Error(response.errorBody().toString())

                } catch (e: Exception) {
                    return DataResult.Error(e.printStackTrace().toString())
                }
            } else {
                return DataResult.Error("No Internet Connection")
            }
        }

    }
}