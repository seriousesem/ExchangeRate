package com.serioussem.exchangerate.data.privatbank.mappers

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import com.serioussem.exchangerate.domain.core.CurrencyRateModel

class PrivatBankResponseToCurrencyRateModelMapper : BaseMapper<PrivatBankResponse, CurrencyRateModel> {

    override fun map(source: PrivatBankResponse): CurrencyRateModel =
        when (source.targetCurrency) {
            targetCurrency.component1() -> CurrencyRateModel(
                countryFlag = countryFlag.component1(),
                currencyFullName = currencyFullName.component1(),
                buyingRate = source.buying_rate,
                sellingRate = source.selling_rate
            )
            targetCurrency.component2() -> CurrencyRateModel(
                countryFlag = countryFlag.component2(),
                currencyFullName = currencyFullName.component2(),
                buyingRate = source.buying_rate,
                sellingRate = source.selling_rate
            )
            else -> CurrencyRateModel(
                countryFlag = countryFlag.component3(),
                currencyFullName = currencyFullName.component3(),
                buyingRate = source.buying_rate,
                sellingRate = source.selling_rate
            )
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
