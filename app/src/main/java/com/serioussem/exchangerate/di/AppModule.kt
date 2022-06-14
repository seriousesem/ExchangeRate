package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.presentation.core.AppDispatchers
import com.serioussem.exchangerate.presentation.home.adapters.CurrencyRateRecyclerViewAdapter
import com.serioussem.exchangerate.presentation.home.adapters.CurrencyRateViewHolder
import com.serioussem.exchangerate.presentation.monobank.MonoBankViewModel
import com.serioussem.exchangerate.presentation.privatbank.PrivatBankViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        PrivatBankViewModel(useCase = get(), dispatchers = get())
    }

    viewModel {
        MonoBankViewModel(useCase = get())
    }

    factory {
        AppDispatchers()
    }
    single {
        CurrencyRateRecyclerViewAdapter()
    }
    single {
        CurrencyRateViewHolder(get())
    }
}