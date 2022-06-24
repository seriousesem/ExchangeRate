package com.serioussem.exchangerate.data.monobank.mappers

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.monobank.model.MonoBankResponse
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.utils.getFiveFirstChars


class MonoBankResponseToCurrencyRateModelMapper : BaseMapper<MonoBankResponse, CurrencyRateModel?> {

    override fun map(source: MonoBankResponse): CurrencyRateModel {

        val responseTargetCurrency = source.targetCurrency
        val rateBuy = source.rateBuy.toString().getFiveFirstChars()
        val rateSell = source.rateSell.toString().getFiveFirstChars()
        val rateCross = source.rateCross.toString().getFiveFirstChars()
        val currencyIndex = targetCurrency.indexOf(responseTargetCurrency)
        var currencyRate = CurrencyRateModel(
            countryFlag = countryFlag[6],
            currencyFullName = currencyFullName[6],
            buyingRate = rateCross,
            sellingRate = rateCross
        )
        if (targetCurrency.contains(responseTargetCurrency)) {
            currencyRate = if (currencyIndex in 0..1) {
                CurrencyRateModel(
                    countryFlag = countryFlag[currencyIndex],
                    currencyFullName = currencyFullName[currencyIndex],
                    buyingRate = rateBuy,
                    sellingRate = rateSell
                )
            } else {
                CurrencyRateModel(
                    countryFlag = countryFlag[currencyIndex],
                    currencyFullName = currencyFullName[currencyIndex],
                    buyingRate = rateCross,
                    sellingRate = rateCross
                )
            }

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