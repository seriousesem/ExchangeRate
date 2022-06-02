package com.serioussem.exchangerate.presentation.privatbank

import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment

class PrivatBankFragment: BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {
    override fun init() {
        initView()
    }

    private fun initView(){
        binding.textView.text = "PrivatBank"
    }
}