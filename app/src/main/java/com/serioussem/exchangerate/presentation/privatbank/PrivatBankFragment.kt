package com.serioussem.exchangerate.presentation.privatbank

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import com.serioussem.exchangerate.utils.collectFlow
import org.koin.androidx.viewmodel.ext.android.viewModel

class PrivatBankFragment : BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    private val viewModel by viewModel<PrivatBankViewModel>()
    private val currencyAdapter by lazy {
        CurrencyRateRecyclerViewAdapter()
    }

    override fun init() {
        initView()
    }

    private fun initView() {
        with(binding) {
            with(currencyRateRecyclerView) {
                setHasFixedSize(true)
                adapter = currencyAdapter
            }
            pageTitle.text = getString(R.string.currency_rate_in_privat_bank)
        }

    }

    override fun collectFlow() {
        collectFlow(viewModel.uiState){
            it.update(binding = binding, adapter = currencyAdapter)
        }
    }
}