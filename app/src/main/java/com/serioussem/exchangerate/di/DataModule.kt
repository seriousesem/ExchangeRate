package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.data.core.InternetConnection
import com.serioussem.exchangerate.data.core.ResponseHandler
import com.serioussem.exchangerate.data.monobank.datasource.MonoBankDataSource
import com.serioussem.exchangerate.data.monobank.mappers.MonoBankDataResultToDomainMapper
import com.serioussem.exchangerate.data.monobank.mappers.MonoBankResponseToCurrencyRateModelMapper
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankDataResultToDomainMapper
import com.serioussem.exchangerate.data.monobank.repository.MonoBankRepositoryImpl
import com.serioussem.exchangerate.data.nbu.mappers.NbuResponseToCurrencyRateModelMapper
import com.serioussem.exchangerate.data.nbu.datasource.NbuDataSource
import com.serioussem.exchangerate.data.nbu.mappers.NbuDataResultToDomainMapper
import com.serioussem.exchangerate.data.nbu.repository.NbuRepositoryImpl
import com.serioussem.exchangerate.data.privatbank.datasource.PrivatBankDataSource
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankResponseToCurrencyRateModelMapper
import com.serioussem.exchangerate.data.privatbank.repository.PrivatBankRepositoryImpl
import com.serioussem.exchangerate.domain.repository.MonoBankRepository
import com.serioussem.exchangerate.domain.repository.NbuRepository
import com.serioussem.exchangerate.domain.repository.PrivatBankRepository
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {

    factory<PrivatBankRepository> {
        PrivatBankRepositoryImpl(dataSource = get(), mapper = get(), get())
    }

    factory<MonoBankRepository> {
        MonoBankRepositoryImpl(dataSource = get(), mapper = get(), dispatcher = get())
    }

    factory<NbuRepository> {
        NbuRepositoryImpl(dataSource = get(), mapper = get(), dispatcher = get())
    }

    factory {
        Dispatchers.IO
    }

    factory {
        ResponseHandler(internetConnection = get(), provider = get())
    }

    factory {
        InternetConnection(context = get())
    }

    factory {
        PrivatBankDataSource(handler = get(), service = get(named("PrivatBankService")))
    }

    factory {
        MonoBankDataSource(handler = get(), service = get(named("MonoBankService")))
    }

    factory {
        NbuDataSource(handler = get(), service = get(named("NbuService")))
    }

    factory {
        PrivatBankResponseToCurrencyRateModelMapper()
    }

    factory {
        PrivatBankDataResultToDomainMapper(mapper = get())
    }

    factory {
        MonoBankResponseToCurrencyRateModelMapper()
    }

    factory {
        MonoBankDataResultToDomainMapper(mapper = get())
    }

    factory {
        NbuResponseToCurrencyRateModelMapper()
    }
    factory {
        NbuDataResultToDomainMapper(mapper = get())
    }

}

