package com.serioussem.exchangerate.presentation.nbu

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NbuFragment : BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    private val viewModel by viewModel<NbuViewModel>()
    private val currencyAdapter by lazy {
        CurrencyRateRecyclerViewAdapter()
    }

    companion object {
        const val title = R.string.currency_rate_in_nbu
    }

    override fun init() {
        super.swipeRefresh(binding, viewModel)
        super.collectFlow(binding, currencyAdapter, viewModel.nbuResult)
        super.initView(binding, currencyAdapter, title)
    }
}