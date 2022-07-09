package com.serioussem.exchangerate.presentation.nbu

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.presentation.core.BaseBankFragment
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NbuBankFragment : BaseBankFragment() {

    private val viewModel by viewModel<NbuViewModel>()

    private val currencyAdapter by lazy {
        CurrencyRateRecyclerViewAdapter()
    }

    companion object {
        const val title = R.string.currency_rate_in_nbu
    }

    override fun init() {
        super.collectFlow(currencyAdapter, viewModel.nbuResult)
        super.initView(currencyAdapter)
        super.swipeRefresh(viewModel)
    }

    override fun updateTitle(): String = getString(title)


}