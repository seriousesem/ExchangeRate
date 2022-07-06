package com.serioussem.exchangerate.data.nbu.mappers

import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.nbu.model.NbuResponse
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.utils.Constants.countryFlag
import com.serioussem.exchangerate.utils.Constants.currencyCode
import com.serioussem.exchangerate.utils.Constants.currencyFullName
import com.serioussem.exchangerate.utils.getFiveFirstChars

class NbuResponseToCurrencyRateModelMapper: BaseMapper<NbuResponse, CurrencyRateModel?> {
    override fun map(source: NbuResponse): CurrencyRateModel {

        val responseTargetCurrency = source.currencyCode
        val responseRate = source.rate.toString().getFiveFirstChars()
        val currencyIndex = currencyCode.indexOf(source.currencyCode)
        var currencyRate = CurrencyRateModel(
            countryFlag = countryFlag.last(),
            currencyFullName = currencyFullName.last(),
            buyingRate = responseRate,
            sellingRate = responseRate
        )
        if (currencyCode.contains(responseTargetCurrency)) {
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
}

