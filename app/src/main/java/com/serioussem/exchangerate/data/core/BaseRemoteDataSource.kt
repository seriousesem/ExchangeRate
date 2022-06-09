package com.serioussem.exchangerate.data.core

import com.serioussem.exchangerate.data.models.DataResult

abstract class BaseRemoteDataSource<T, S>(
    private val internetConnection: InternetConnection,
    private val service: BaseRetrofitService<T>,
    private val mapper: BaseMapper<T, S>
) {
   open suspend fun fetch(): DataResult<S> {
        if (internetConnection.isConnected()) {
            try {
                val response = service.fetch()
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    return DataResult.Success(mapper.map(body))
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