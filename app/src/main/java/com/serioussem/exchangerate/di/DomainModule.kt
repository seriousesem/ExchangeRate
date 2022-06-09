package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.domain.monobank.usecase.MonoBankCurrencyRate
import com.serioussem.exchangerate.domain.privatbank.usecase.PrivatBankCurrencyRate
import org.koin.dsl.module

val domainModule = module {

    factory {
        PrivatBankCurrencyRate(repository = get())
    }

    factory {
        MonoBankCurrencyRate(repository = get())
    }


}