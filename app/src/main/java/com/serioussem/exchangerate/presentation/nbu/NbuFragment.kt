package com.serioussem.exchangerate.presentation.nbu

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment

class NbuFragment : BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {
    override fun init() {
        initView()
    }

    private fun initView() {
        with(binding) {
//            with(currencyRateRecyclerView) {
//                setHasFixedSize(true)
//                adapter = currencyAdapter
//            }
            pageTitle.text = getString(R.string.currency_rate_in_nbu)
        }
    }
}