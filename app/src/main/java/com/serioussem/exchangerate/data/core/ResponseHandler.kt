package com.serioussem.exchangerate.data.core

import android.util.Log
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import retrofit2.Response

class ResponseHandler(
    private val internetConnection: InternetConnection,
    private val provider: ResourceProvider

    ) {
    suspend fun <T> fetch(
        apiRequest: suspend () -> Response<T>
    ): CurrencyDataResult<T> {
        if (internetConnection.isConnected()) {
            try {
                val response = apiRequest.invoke()
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    return CurrencyDataResult.Success(body)
                }
                return CurrencyDataResult.Error("Невдалий запит, спробуйте через кілька хвилин")

            } catch (e: Exception) {
                return CurrencyDataResult.Error("Інша помилка")
            }
        } else {
            return CurrencyDataResult.Error("No Internet Connection")
        }
    }
}