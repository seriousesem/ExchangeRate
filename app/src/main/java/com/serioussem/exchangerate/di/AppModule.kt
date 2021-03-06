package com.serioussem.exchangerate.di

import com.serioussem.exchangerate.presentation.core.UiState
import com.serioussem.exchangerate.utils.AppDispatchers
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateViewHolder
import com.serioussem.exchangerate.presentation.monobank.MonoBankViewModel
import com.serioussem.exchangerate.presentation.nbu.NbuViewModel
import com.serioussem.exchangerate.presentation.privatbank.PrivatBankViewModel
import com.serioussem.exchangerate.utils.ResourceProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        PrivatBankViewModel(repository = get(), dispatchers = get(), uiState = get())
    }
    viewModel {
        MonoBankViewModel(repository = get(), dispatchers = get(), uiState = get())
    }
    viewModel {
        NbuViewModel(repository = get(), dispatchers = get(), uiState = get())
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
        CurrencyRateViewHolder(binding = get())
    }
    factory {
        ResourceProvider(context = get())
    }
}