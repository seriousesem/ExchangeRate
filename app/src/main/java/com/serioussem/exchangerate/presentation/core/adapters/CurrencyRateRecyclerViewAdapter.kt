package com.serioussem.exchangerate.presentation.core.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serioussem.exchangerate.databinding.CurrencyRateViewHolderItemBinding
import com.serioussem.exchangerate.domain.core.CurrencyRateModel

@SuppressLint("NotifyDataSetChanged")
class CurrencyRateRecyclerViewAdapter() :
    RecyclerView.Adapter<CurrencyRateViewHolder>() {

    var items = listOf<CurrencyRateModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyRateViewHolder =
        CurrencyRateViewHolder(
            CurrencyRateViewHolderItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CurrencyRateViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

}