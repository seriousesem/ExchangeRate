package com.serioussem.exchangerate.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import com.serioussem.exchangerate.utils.collectFlow
import kotlinx.coroutines.flow.Flow

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(private val inflate: Inflate<VB>) : Fragment() {

    private var bindingMutable: VB? = null
    val binding get() = bindingMutable!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingMutable = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingMutable = null
    }

    abstract fun init()

    fun collectFlow(
        binding: BankFragmentBinding,
        currencyAdapter: CurrencyRateRecyclerViewAdapter,
        flow: Flow<UiState>
    ) {
        collectFlow(flow) {
            it.updateUi(binding = binding, adapter = currencyAdapter)
        }
    }

    fun initView(
        binding: BankFragmentBinding,
        currencyAdapter: CurrencyRateRecyclerViewAdapter,
        title: Int
    ) {
        with(binding) {
            with(currencyRateRecyclerView) {
                setHasFixedSize(true)
                adapter = currencyAdapter
            }
            pageTitle.text = getString(title)
        }
    }

    fun swipeRefresh(
        binding: BankFragmentBinding,
        viewModel: BaseViewModel
    ) {
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