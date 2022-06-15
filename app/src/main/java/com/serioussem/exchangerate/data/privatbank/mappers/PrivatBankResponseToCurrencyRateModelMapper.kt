package com.serioussem.exchangerate.data.privatbank.mappers

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import com.serioussem.exchangerate.domain.core.CurrencyRateModel

class PrivatBankResponseToCurrencyRateModelMapper : BaseMapper<PrivatBankResponse, CurrencyRateModel> {

    override fun map(source: PrivatBankResponse): CurrencyRateModel {
        val responseTargetCurrency = source.targetCurrency
        val currencyIndex = targetCurrency.indexOf(responseTargetCurrency)
        var currencyRate = CurrencyRateModel(
            countryFlag = countryFlag.component1(),
            currencyFullName = currencyFullName.component1(),
            buyingRate = source.buying_rate,
            sellingRate = source.selling_rate
        )
        if (targetCurrency.contains(responseTargetCurrency)) {
            currencyRate = CurrencyRateModel(
                countryFlag = countryFlag[currencyIndex],
                currencyFullName = currencyFullName[currencyIndex],
                buyingRate = source.buying_rate.dropLast(3),
                sellingRate = source.selling_rate.dropLast(3)
            )
        }
        return currencyRate
    }
    private val targetCurrency = listOf("USD", "EUR", "BTC")
    private val currencyFullName = listOf(
        R.string.dollar_usa,
        R.string.euro,
        R.string.bitcoin
    )
    private val countryFlag = listOf(
        R.drawable.us,
        R.drawable.eur,
        R.drawable.bitcoin
    )

}
