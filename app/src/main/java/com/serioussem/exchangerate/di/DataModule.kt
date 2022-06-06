package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.data.core.InternetConnection
import com.serioussem.exchangerate.data.monobank.repository.MonoBankRepositoryImpl
import com.serioussem.exchangerate.data.privatbank.repository.PrivatBankRepositoryImpl
import com.serioussem.exchangerate.domain.monobank.repository.MonoBankRepository
import com.serioussem.exchangerate.domain.privatbank.repository.PrivatBankRepository
import org.koin.dsl.module

val dataModule = module {

    single<PrivatBankRepository> {
        PrivatBankRepositoryImpl()
    }

    single<MonoBankRepository> {
        MonoBankRepositoryImpl()
    }

    factory {
        InternetConnection(context = get())
    }

}

