package com.serioussem.exchangerate.data.privatbank.datasource

import android.util.Log
import com.serioussem.exchangerate.data.core.BaseRemoteDataSource
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.core.InternetConnection
import com.serioussem.exchangerate.data.models.DataModelList
import com.serioussem.exchangerate.data.models.DataResult
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankResponseToDataListMapper
import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import com.serioussem.exchangerate.data.privatbank.retrofit.PrivatBankService

class PrivatBankRemoteDataSource(
    private val internetConnection: InternetConnection,
    private val service: PrivatBankService,
    private val mapper: PrivatBankResponseToDataListMapper
)  {

    suspend fun fetch(): DataResult<DataModelList> {
        Log.d("Sem", "start ds")
        if (internetConnection.isConnected()) {
            try {
                val response = service.fetch()
                val body = response.body()

                if (response.isSuccessful && body != null) {
                    Log.d("Sem", body.toString())
                    return DataResult.Success(mapper.map(body))
                }
                Log.d("Sem", "error1")
                return DataResult.Error(response.errorBody().toString())

            } catch (e: Exception) {
                Log.d("Sem", "error2")
                return DataResult.Error(e.printStackTrace().toString())
            }
        } else {
            Log.d("Sem", "error3")
            return DataResult.Error("No Internet Connection")
        }
    }
}