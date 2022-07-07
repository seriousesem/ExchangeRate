package com.serioussem.exchangerate.presentation.monobank

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MonoBankFragment : BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    private val viewModel by viewModel<MonoBankViewModel>()
    private val currencyAdapter by lazy {
        CurrencyRateRecyclerViewAdapter()
    }

    companion object{
        const val title = R.string.currency_rate_in_mono_bank
    }
    override fun init() {
        super.swipeRefresh(binding, viewModel)
        super.collectFlow(binding, currencyAdapter, viewModel.monoBankResult)
        super.initView(binding, currencyAdapter, title)
    }
}