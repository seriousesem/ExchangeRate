package com.serioussem.exchangerate.presentation.privatbank

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseBankFragment
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PrivatBankBankFragment : BaseBankFragment() {

    private val viewModel by viewModel<PrivatBankViewModel>()
    private val currencyAdapter by lazy {
        CurrencyRateRecyclerViewAdapter()
    }

    companion object {
        const val title = R.string.currency_rate_in_privat_bank
    }
    override fun init() {
        super.swipeRefresh(viewModel)
        super.collectFlow(currencyAdapter, viewModel.privatBankResult)
        super.initView(currencyAdapter)
    }

    override fun updateTitle(): String = getString(title)
}