package com.serioussem.exchangerate.presentation.monobank

import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MonoBankFragment : BaseFragment<BankFragmentBinding>(BankFragmentBinding::inflate) {

    private val viewModel by viewModel<MonoBankViewModel>()
    private val currencyAdapter by lazy {
        CurrencyRateRecyclerViewAdapter()
    }

    override fun init() {
        initView()
        initData()
    }

    private fun initView() {
        with(binding) {
            with(currencyRateRecyclerView) {
                setHasFixedSize(true)
                adapter = currencyAdapter
            }
            pageTitle.text = getString(R.string.currency_rate_in_mono_bank)
        }

    }

    private fun initData() {
        viewModel.data.observe(viewLifecycleOwner) {
            when (it) {
                is CurrencyDomainResult.Success<*> -> {
                    Log.d("Sem", "${it.data}")
                    currencyAdapter.items = it.data as List<CurrencyRateModel>
                }
                is CurrencyDomainResult.Error<*> -> {
                    activity?.let { it1 ->
                        Snackbar.make(
                            it1.findViewById(android.R.id.content),
                            "${it.message}!",
                            Snackbar.LENGTH_LONG
                        ).show()
                    };
                }
                else -> {}
            }
        }
    }

}