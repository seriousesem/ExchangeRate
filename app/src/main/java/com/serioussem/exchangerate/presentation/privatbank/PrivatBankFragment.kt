package com.serioussem.exchangerate.presentation.privatbank

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.presentation.monobank.MonoBankViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PrivatBankFragment: BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    private val viewModel by viewModel<PrivatBankViewModel>()

    override fun init() {
        updatePageTitle()
    }

    override fun updatePageTitle(){
        binding.pageTitle.text = getString(R.string.currency_rate_in_privat_bank)
    }
}