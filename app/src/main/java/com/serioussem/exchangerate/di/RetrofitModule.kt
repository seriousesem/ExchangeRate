package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.data.monobank.retrofit.MonoBankService
import com.serioussem.exchangerate.data.privatbank.retrofit.PrivatBankService
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val PRIVAT_BANK_URL = "https://api.privatbank.ua/p24api/"
private const val MONO_BANK_URL = "https"

val privatBankRetrofitModule = module {

    single(named("PrivatBankClient")) {
        createdHttpClient()
    }

    single(named("PrivatBankService")) {
        createdRetrofitService<PrivatBankService>(
            baseUrl = PRIVAT_BANK_URL,
            okHttpClient = get(named("PrivatBankClient"))
        )
    }
}
val monoBankRetrofitModule = module {

    single(named("MonoBankClient")) {
        createdHttpClient()
    }

    single {
        createdRetrofitService<MonoBankService>(
            baseUrl = MONO_BANK_URL,
            okHttpClient = get(named("MonoBankClient"))
        )
    }
}

fun createdHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

inline fun <reified T> createdRetrofitService(baseUrl: String, okHttpClient: OkHttpClient): PrivatBankService {
    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(PrivatBankService::class.java)

}
