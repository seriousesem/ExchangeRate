package com.serioussem.exchangerate.presentation.monobank

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment


class MonoBankFragment : BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    override fun init() {
        updatePageTitle()
    }

    override fun updatePageTitle() {
       binding.pageTitle.text = getString(R.string.currency_rate_in_mono_bank)
    }

}