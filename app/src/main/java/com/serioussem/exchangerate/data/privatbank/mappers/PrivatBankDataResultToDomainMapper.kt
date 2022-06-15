package com.serioussem.exchangerate.data.privatbank.mappers

import com.serioussem.exchangerate.data.core.CurrencyDataResult
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import com.serioussem.exchangerate.domain.core.CurrencyRateModel
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult

class PrivatBankDataResultToDomainMapper(private val mapper: PrivatBankResponseToCurrencyRateModelMapper) :
    BaseMapper<CurrencyDataResult<List<PrivatBankResponse>>, CurrencyDomainResult<List<CurrencyRateModel>>> {

    override fun map(source: CurrencyDataResult<List<PrivatBankResponse>>): CurrencyDomainResult<List<CurrencyRateModel>> =
        when (source) {
            is CurrencyDataResult.Success -> {
                val currencyRateModelList = mutableListOf<CurrencyRateModel>()
                source.data?.forEach {
                    currencyRateModelList.add(mapper.map(it))
                }
                CurrencyDomainResult.Success(data = currencyRateModelList)
            }
            is CurrencyDataResult.Error -> CurrencyDomainResult.Error(message = source.message as String)
            else -> CurrencyDomainResult.Loading()
        }
}