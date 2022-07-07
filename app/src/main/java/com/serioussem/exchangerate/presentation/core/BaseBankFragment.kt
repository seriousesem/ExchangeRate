package com.serioussem.exchangerate.presentation.core

import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import com.serioussem.exchangerate.utils.collectFlow
import kotlinx.coroutines.flow.Flow

abstract class BaseBankFragment : BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    fun collectFlow(
        currencyAdapter: CurrencyRateRecyclerViewAdapter,
        flow: Flow<UiState>
    ) {
        collectFlow(flow) {
            it.updateUi(binding = binding, adapter = currencyAdapter)
        }
    }

    fun initView(
        currencyAdapter: CurrencyRateRecyclerViewAdapter
    ) {
        with(binding) {
            with(currencyRateRecyclerView) {
                setHasFixedSize(true)
                adapter = currencyAdapter
            }
            pageTitle.text = updateTitle()
        }
    }

    fun swipeRefresh(
        viewModel: BaseViewModel
    ) {
        with(binding) {
            with(swipeRefreshLayout) {
                setOnRefreshListener {
                    viewModel.fetchCurrencyRate()
                    isRefreshing = false
                }
            }
        }
    }

    abstract fun updateTitle(): String
}