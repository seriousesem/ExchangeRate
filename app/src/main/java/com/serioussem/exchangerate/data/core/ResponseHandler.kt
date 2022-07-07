package com.serioussem.exchangerate.data.core

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.utils.ResourceProvider
import retrofit2.Response

class ResponseHandler(
    private val internetConnection: InternetConnection,
    private val resourceProvider: ResourceProvider
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
                return CurrencyDataResult.Error(resourceProvider.string(R.string.loading_error))

            } catch (e: Exception) {
                return CurrencyDataResult.Error(e.message.toString())
            }
        } else {
            return CurrencyDataResult.Error(resourceProvider.string(R.string.internet_error))
        }
    }
}