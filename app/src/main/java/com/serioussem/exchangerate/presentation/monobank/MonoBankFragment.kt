package com.serioussem.exchangerate.presentation.monobank

import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment


class MonoBankFragment : BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    override fun init() {
        initView()
    }
    private fun initView(){
        binding.textView.text = "MonoBank"
    }
}