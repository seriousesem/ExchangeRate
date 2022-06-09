package com.serioussem.exchangerate.presentation.privatbank

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.domain.core.DomainResult
import com.serioussem.exchangerate.presentation.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PrivatBankFragment: BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    private val viewModel by viewModel<PrivatBankViewModel>()

    override fun init() {
        updatePageTitle()
        initObservers()
    }

    override fun updatePageTitle(){
        binding.pageTitle.text = getString(R.string.currency_rate_in_privat_bank)
    }

    private fun initObservers(){
        viewModel.data.observe(viewLifecycleOwner){result ->
            when(result){
                is DomainResult.Success -> result.data?.domainModelList?.forEach {
                    binding.testContent.text = it.toString()
                }
            }
        }
    }
}