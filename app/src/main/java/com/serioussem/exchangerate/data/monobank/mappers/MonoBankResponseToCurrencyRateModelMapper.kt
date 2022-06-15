package com.serioussem.exchangerate.data.monobank.mappers

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.monobank.model.MonoBankResponse
import com.serioussem.exchangerate.domain.core.CurrencyRateModel

class MonoBankResponseToCurrencyRateModelMapper: BaseMapper<MonoBankResponse, CurrencyRateModel> {

    override fun map(source: MonoBankResponse): CurrencyRateModel =
        when (source.targetCurrency){

        }

    private val targetCurrency = listOf(840, 978, 826, 392, 756, 156)
    private val currencyFullName = listOf(
        R.string.dollar_usa,
        R.string.euro,
        R.string.pound_sterling,
        R.string.japanese_yen,
        R.string.swiss_franc,
        R.string.yuan_renminbi
    )
    private val countryFlag = listOf(
        R.drawable.usa,
        R.drawable.eur,
        R.drawable.bitcoin
    )

}