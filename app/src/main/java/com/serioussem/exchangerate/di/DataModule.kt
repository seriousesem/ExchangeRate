package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.data.core.InternetConnection
import com.serioussem.exchangerate.data.core.ResponseHandler
import com.serioussem.exchangerate.data.core.ResourceProvider
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankDataResultToDomainMapper
import com.serioussem.exchangerate.data.monobank.repository.MonoBankRepositoryImpl
import com.serioussem.exchangerate.data.privatbank.datasource.PrivatBankDataSource
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankResponseToCurrencyModelMapper
import com.serioussem.exchangerate.data.privatbank.repository.PrivatBankRepositoryImpl
import com.serioussem.exchangerate.domain.monobank.repository.MonoBankRepository
import com.serioussem.exchangerate.domain.privatbank.repository.PrivatBankRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {

    factory<PrivatBankRepository> {
        PrivatBankRepositoryImpl(dataSource = get(), mapper = get())
    }

    factory<MonoBankRepository> {
        MonoBankRepositoryImpl()
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
        PrivatBankResponseToCurrencyModelMapper()
    }

    factory {
        PrivatBankDataResultToDomainMapper(mapper = get())
    }

}

