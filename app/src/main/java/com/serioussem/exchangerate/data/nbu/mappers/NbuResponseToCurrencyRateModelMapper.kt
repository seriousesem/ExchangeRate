package com.serioussem.exchangerate.data.nbu.mappers

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.nbu.model.NbuResponse
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.utils.getFiveFirstChars

class NbuResponseToCurrencyRateModelMapper: BaseMapper<NbuResponse, CurrencyRateModel?> {
    override fun map(source: NbuResponse): CurrencyRateModel {

        val responseTargetCurrency = source.currencyCode
        val responseRate = source.rate.toString().getFiveFirstChars()
        val currencyIndex = targetCurrency.indexOf(source.currencyCode)
        var currencyRate = CurrencyRateModel(
            countryFlag = countryFlag[6],
            currencyFullName = currencyFullName[6],
            buyingRate = responseRate,
            sellingRate = responseRate
        )
        if (targetCurrency.contains(responseTargetCurrency)) {
            currencyRate =
                CurrencyRateModel(
                    countryFlag = countryFlag[currencyIndex],
                    currencyFullName = currencyFullName[currencyIndex],
                    buyingRate = responseRate,
                    sellingRate = responseRate
             )
        }
        return currencyRate
    }

    private val targetCurrency =
        listOf(840, 978, 826, 392, 756, 156)

    private val currencyFullName = listOf(
        R.string.dollar_usa,
        R.string.euro,
        R.string.pound_sterling,
        R.string.japanese_yen,
        R.string.swiss_franc,
        R.string.yuan_renminbi,
        R.string.any_currency
    )
    private val countryFlag = listOf(
        R.drawable.us,
        R.drawable.eur,
        R.drawable.gb,
        R.drawable.jp,
        R.drawable.ch,
        R.drawable.cn,
        R.drawable.noting
    )
}