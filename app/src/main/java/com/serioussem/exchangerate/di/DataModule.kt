package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.data.core.InternetConnection
import com.serioussem.exchangerate.data.core.ResourceProvider
import com.serioussem.exchangerate.data.mappers.DataModelListToDomain
import com.serioussem.exchangerate.data.mappers.DataModelToDomain
import com.serioussem.exchangerate.data.mappers.DataResultToDomainMapper
import com.serioussem.exchangerate.data.monobank.repository.MonoBankRepositoryImpl
import com.serioussem.exchangerate.data.privatbank.datasource.PrivatBankRemoteDataSource
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankModelToDataMapper
import com.serioussem.exchangerate.data.privatbank.mappers.PrivatBankResponseToDataListMapper
import com.serioussem.exchangerate.data.privatbank.repository.PrivatBankRepositoryImpl
import com.serioussem.exchangerate.domain.monobank.repository.MonoBankRepository
import com.serioussem.exchangerate.domain.privatbank.repository.PrivatBankRepository
import org.koin.core.qualifier.named
import org.koin.core.scope.get
import org.koin.dsl.module

val dataModule = module {

    factory<PrivatBankRepository> {
        PrivatBankRepositoryImpl(dataSource = get(), mapper = get())
    }

    factory<MonoBankRepository> {
        MonoBankRepositoryImpl()
    }

    factory {
        PrivatBankRemoteDataSource(internetConnection = get(), service = get(named("PrivatBankService")), mapper = get())
    }

    factory {
        InternetConnection(context = get())
    }

    factory {
        ResourceProvider(context = get())
    }

    factory {
        DataModelListToDomain(mapper = get())
    }

    factory {
        DataModelToDomain()
    }

    factory {
        DataResultToDomainMapper(mapper = get())
    }

    factory {
        PrivatBankModelToDataMapper()
    }

    factory {
        PrivatBankResponseToDataListMapper(mapper = get())
    }
}

