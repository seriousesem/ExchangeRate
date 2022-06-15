package com.serioussem.exchangerate.presentation.core.adapters

import androidx.recyclerview.widget.RecyclerView
import com.serioussem.exchangerate.databinding.CurrencyRateViewHolderItemBinding
import com.serioussem.exchangerate.domain.core.CurrencyRateModel

class CurrencyRateViewHolder(private val binding: CurrencyRateViewHolderItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(currencyRateModel: CurrencyRateModel) {
        with (binding) {
            countryFlag.setImageResource(currencyRateModel.countryFlag)
            currencyFullName.setText(currencyRateModel.currencyFullName)
            buyingRate.text = currencyRateModel.buyingRate
            sellingRate.text = currencyRateModel.sellingRate
        }
    }
}