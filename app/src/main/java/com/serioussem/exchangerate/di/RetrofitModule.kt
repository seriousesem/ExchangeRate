package com.serioussem.exchangerate.di


import com.serioussem.exchangerate.data.monobank.retrofit.MonoBankService
import com.serioussem.exchangerate.data.nbu.retrofit.NbuService
import com.serioussem.exchangerate.data.privatbank.retrofit.PrivatBankService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val PRIVAT_BANK_URL = "https://api.privatbank.ua/p24api/"
private const val MONO_BANK_URL = "https://api.monobank.ua/"
private const val NBU_URL = "https://bank.gov.ua/"

val privatBankRetrofitModule = module {
    single(named("PrivatBankInterceptor")) {
        createLoggingInterceptor()
    }
    single(named("PrivatBankClient")) {
        createOkHttpClient(get(named("PrivatBankInterceptor")))
    }
    single(named("PrivatBankRetrofit")) {
        createRetrofit(PRIVAT_BANK_URL, get(named("PrivatBankClient")))
    }
    single(named("PrivatBankService")) {
        createRetrofitService<PrivatBankService>(get(named("PrivatBankRetrofit")))
    }
}
val monoBankRetrofitModule = module {
    single(named("MonoBankInterceptor")) {
        createLoggingInterceptor()
    }
    single(named("MonoBankClient")) {
        createOkHttpClient(get(named("MonoBankInterceptor")))
    }
    single(named("MonoBankRetrofit")) {
        createRetrofit(MONO_BANK_URL, get(named("MonoBankClient")))
    }
    single(named("MonoBankService")) {
        createRetrofitService<MonoBankService>(get(named("MonoBankRetrofit")))
    }
}
val nbuRetrofitModule = module {
    single(named("NbuInterceptor")) {
        createLoggingInterceptor()
    }
    single(named("NbuClient")) {
        createOkHttpClient(get(named("NbuInterceptor")))
    }
    single(named("NbuRetrofit")) {
        createRetrofit(NBU_URL, get(named("NbuClient")))
    }
    single(named("NbuService")) {
        createRetrofitService<NbuService>(get(named("NbuRetrofit")))
    }
}

fun createLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

fun createOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        .callTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

fun createRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

inline fun <reified T> createRetrofitService(retrofit: Retrofit): T =
    retrofit.create(T::class.java)

