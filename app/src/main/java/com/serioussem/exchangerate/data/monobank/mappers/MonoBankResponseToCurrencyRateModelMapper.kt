package com.serioussem.exchangerate.data.monobank.mappers

import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.monobank.model.MonoBankResponse
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.utils.Constants.countryFlag
import com.serioussem.exchangerate.utils.Constants.currencyCode
import com.serioussem.exchangerate.utils.Constants.currencyFullName
import com.serioussem.exchangerate.utils.getFiveFirstChars


class MonoBankResponseToCurrencyRateModelMapper : BaseMapper<MonoBankResponse, CurrencyRateModel?> {

    override fun map(source: MonoBankResponse): CurrencyRateModel {

        val responseTargetCurrency = source.targetCurrency
        val rateBuy = source.rateBuy.toString().getFiveFirstChars()
        val rateSell = source.rateSell.toString().getFiveFirstChars()
        val rateCross = source.rateCross.toString().getFiveFirstChars()
        val currencyIndex = currencyCode.indexOf(responseTargetCurrency)
        var currencyRate = CurrencyRateModel(
            countryFlag = countryFlag[6],
            currencyFullName = currencyFullName[6],
            buyingRate = rateCross,
            sellingRate = rateCross
        )
        if (currencyCode.contains(responseTargetCurrency)) {
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
}