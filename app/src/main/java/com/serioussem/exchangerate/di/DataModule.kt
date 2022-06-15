package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.data.core.InternetConnection
import com.serioussem.exchangerate.data.core.ResponseHandler
import com.serioussem.exchangerate.data.core.ResourceProvider
import com.serioussem.exchangerate.data.monobank.datasource.MonoBankDataSource
import com.serioussem.exchangerate.data.monobank.mappers.MonoBankDataResultToDomainMapper
import com.serioussem.exchangerate.data.monobank.mappers.MonoBankResponseToCurrencyRateModelMapper
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankDataResultToDomainMapper
import com.serioussem.exchangerate.data.monobank.repository.MonoBankRepositoryImpl
import com.serioussem.exchangerate.data.privatbank.datasource.PrivatBankDataSource
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankResponseToCurrencyRateModelMapper
import com.serioussem.exchangerate.data.privatbank.repository.PrivatBankRepositoryImpl
import com.serioussem.exchangerate.domain.repository.MonoBankRepository
import com.serioussem.exchangerate.domain.repository.PrivatBankRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {

    factory<PrivatBankRepository> {
        PrivatBankRepositoryImpl(dataSource = get(), mapper = get())
    }

    factory<MonoBankRepository> {
        MonoBankRepositoryImpl(dataSource = get(), mapper = get())
    }

    factory {
        ResponseHandler(internetConnection = get(), provider = get())
    }

    factory {
        InternetConnection(context = get())
    }

    factory {
        ResourceProvider(context = get())
    }

    factory {
        PrivatBankDataSource(handler = get(), service = get(named("PrivatBankService")))
    }

    factory {
        MonoBankDataSource(handler = get(), service = get(named("MonoBankService")))
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

}

