package com.serioussem.exchangerate.data.monobank.mappers

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.monobank.model.MonoBankResponse
import com.serioussem.exchangerate.domain.core.CurrencyRateModel

class MonoBankResponseToCurrencyRateModelMapper : BaseMapper<MonoBankResponse, CurrencyRateModel> {

    override fun map(source: MonoBankResponse): CurrencyRateModel =
        when (source.targetCurrency) {
            targetCurrency.component1() -> CurrencyRateModel(
                countryFlag = countryFlag.component1(),
                currencyFullName = currencyFullName.component1(),
                buyingRate = source.rateBuy.toString(),
                sellingRate = source.rateSell.toString()
            )
            targetCurrency.component2() -> CurrencyRateModel(
                countryFlag = countryFlag.component2(),
                currencyFullName = currencyFullName.component2(),
                buyingRate = source.rateBuy.toString(),
                sellingRate = source.rateSell.toString()
            )
            targetCurrency.component3() -> CurrencyRateModel(
                countryFlag = countryFlag.component3(),
                currencyFullName = currencyFullName.component3(),
                buyingRate = source.rateBuy.toString(),
                sellingRate = source.rateSell.toString()
            )
            targetCurrency.component4() -> CurrencyRateModel(
                countryFlag = countryFlag.component4(),
                currencyFullName = currencyFullName.component4(),
                buyingRate = source.rateBuy.toString(),
                sellingRate = source.rateSell.toString()
            )
            targetCurrency.component5() -> CurrencyRateModel(
                countryFlag = countryFlag.component5(),
                currencyFullName = currencyFullName.component5(),
                buyingRate = source.rateBuy.toString(),
                sellingRate = source.rateSell.toString()
            )
            targetCurrency[5] -> CurrencyRateModel(
                countryFlag = countryFlag[5],
                currencyFullName = currencyFullName[5],
                buyingRate = source.rateBuy.toString(),
                sellingRate = source.rateSell.toString()
            )
            else -> CurrencyRateModel(
                countryFlag = countryFlag[5],
                currencyFullName = currencyFullName[5],
                buyingRate = source.rateBuy.toString(),
                sellingRate = source.rateSell.toString()
            )
        }

    private
    val targetCurrency = listOf(840, 978, 826, 392, 756, 156)

    private
    val currencyFullName = listOf(
        R.string.dollar_usa,
        R.string.euro,
        R.string.pound_sterling,
        R.string.japanese_yen,
        R.string.swiss_franc,
        R.string.yuan_renminbi
    )

    private
    val countryFlag = listOf(
        R.drawable.us,
        R.drawable.eur,
        R.drawable.gb,
        R.drawable.jp,
        R.drawable.ch,
        R.drawable.cn
    )

}