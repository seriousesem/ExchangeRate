package com.serioussem.exchangerate.data.monobank.mappers

import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.core.CurrencyDataResult
import com.serioussem.exchangerate.data.monobank.model.MonoBankResponse
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel

class MonoBankDataResultToDomainMapper(private var mapper: MonoBankResponseToCurrencyRateModelMapper) :
    BaseMapper<CurrencyDataResult<List<MonoBankResponse>>, CurrencyDomainResult<List<CurrencyRateModel>>> {

    private val usdCode = 840

    override fun map(source: CurrencyDataResult<List<MonoBankResponse>>):
            CurrencyDomainResult<List<CurrencyRateModel>> =
        when (source) {
            is CurrencyDataResult.Success -> {
                val currencyRateModelList = mutableListOf<CurrencyRateModel>()
                source.data?.forEach {
                    if (it.baseCurrency == usdCode) return@forEach
                    currencyRateModelList.add(mapper.map(it))
                }
                CurrencyDomainResult.Success(data = currencyRateModelList)
            }
            is CurrencyDataResult.Error -> CurrencyDomainResult.Error(message = source.message as String)
            else -> CurrencyDomainResult.Loading()
        }
}