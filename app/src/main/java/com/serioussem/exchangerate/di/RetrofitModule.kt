package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.data.monobank.retrofit.MonoBankService
import com.serioussem.exchangerate.data.privatbank.retrofit.PrivatBankService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val PRIVAT_BANK_URL = "https://api.privatbank.ua/p24api/"
private const val MONO_BANK_URL = "https"

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

val privatBankServiceModule = module {
    single {
        get<Retrofit>().create(PrivatBankService::class.java)
    }
}
val monoBankServiceModule = module {
    single {
        get<Retrofit>().create(MonoBankService::class.java)
    }
}
val privatBankRetrofitModule = module {
    includes(retrofitClientModule(PRIVAT_BANK_URL), privatBankServiceModule)
}
val monoBankRetrofitModule = module {
    includes(retrofitClientModule(MONO_BANK_URL), monoBankServiceModule)
}