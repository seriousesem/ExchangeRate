package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.presentation.core.UiState
import com.serioussem.exchangerate.utils.AppDispatchers
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateViewHolder
import com.serioussem.exchangerate.presentation.monobank.MonoBankViewModel
import com.serioussem.exchangerate.presentation.privatbank.PrivatBankViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val appModule = module {

    viewModel {
        PrivatBankViewModel(repository = get(), dispatchers = get(), uiState = get())
    }

    viewModel {
        MonoBankViewModel(repository = get(), dispatchers = get(), uiState = get())
    }

    factory {
        AppDispatchers()
    }
    factory {
        UiState()
    }
    single {
        CurrencyRateRecyclerViewAdapter()
    }
    single {
        CurrencyRateViewHolder(get())
    }

}