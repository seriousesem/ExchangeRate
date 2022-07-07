package com.serioussem.exchangerate.presentation.privatbank

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import com.serioussem.exchangerate.presentation.monobank.MonoBankFragment
import com.serioussem.exchangerate.utils.collectFlow
import org.koin.androidx.viewmodel.ext.android.viewModel

class PrivatBankFragment : BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    private val viewModel by viewModel<PrivatBankViewModel>()
    private val currencyAdapter by lazy {
        CurrencyRateRecyclerViewAdapter()
    }

    companion object {
        const val title = R.string.currency_rate_in_privat_bank
    }
    override fun init() {
        super.swipeRefresh(binding, viewModel)
        super.collectFlow(binding, currencyAdapter, viewModel.privatBankResult)
        super.initView(binding, currencyAdapter, title)
    }
}