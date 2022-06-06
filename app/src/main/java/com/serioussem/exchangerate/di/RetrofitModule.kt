package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.data.monobank.datasource.retrofit.MonoBankService
import com.serioussem.exchangerate.data.privatbank.datasource.retrofit.PrivatBankService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


fun retrofitClientModule(baseUrl: String) = module {

    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

val privatBankRetrofitServiceModule = module {
    single {
        get<Retrofit>().create(PrivatBankService::class.java)
    }
}
val monoBankRetrofitServiceModule = module {
    single {
        get<Retrofit>().create(MonoBankService::class.java)
    }
}