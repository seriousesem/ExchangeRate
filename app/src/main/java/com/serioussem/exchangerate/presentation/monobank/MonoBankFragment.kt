package com.serioussem.exchangerate.presentation.monobank

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import com.serioussem.exchangerate.utils.collectFlow
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
        swipeRefresh()
        initView()
    }

    private fun initView() {
        with(binding) {
            with(currencyRateRecyclerView) {
                setHasFixedSize(true)
                adapter = currencyAdapter
            }
            pageTitle.text = getString(title)
        }

    }

    override fun collectFlow() {
        collectFlow(viewModel.result){
            it.updateUi(binding = binding, adapter = currencyAdapter)
        }
    }
    private fun swipeRefresh() {
        with(binding) {
            with(swipeRefreshLayout) {
                setOnRefreshListener {
                    viewModel.fetchCurrencyRate()
                    isRefreshing = false
                }

            }
        }
    }

}