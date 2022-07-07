package com.serioussem.exchangerate.presentation.core

import com.serioussem.exchangerate.databinding.BankFragmentBinding
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.presentation.core.adapters.CurrencyRateRecyclerViewAdapter
import com.serioussem.exchangerate.utils.hideView
import com.serioussem.exchangerate.utils.showSnackBar
import com.serioussem.exchangerate.utils.showView

data class UiState(
    private val loading: Boolean = false,
    private val currencyRateList: List<CurrencyRateModel> = listOf(),
    private val errorMessage: String? = null
) {
    fun updateUi(binding: BankFragmentBinding, adapter: CurrencyRateRecyclerViewAdapter) {
        if (loading) {
            binding.currencyRateRecyclerView.hideView()
            binding.progressBar.showView()
        }
        if (errorMessage?.isNotBlank() == true) {
            binding.progressBar.hideView()
            binding.errorMessageTextView.showSnackBar(errorMessage)
        }

        if (currencyRateList.isNotEmpty()) {
            binding.progressBar.hideView()
            binding.currencyRateRecyclerView.showView()
            adapter.items = currencyRateList
        }
    }
}