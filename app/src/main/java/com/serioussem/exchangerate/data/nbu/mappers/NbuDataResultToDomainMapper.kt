package com.serioussem.exchangerate.data.nbu.mappers

import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.data.core.CurrencyDataResult
import com.serioussem.exchangerate.data.nbu.model.NbuResponse
import com.serioussem.exchangerate.domain.core.CurrencyDomainResult
import com.serioussem.exchangerate.domain.core.CurrencyRateModel

class NbuDataResultToDomainMapper(private var mapper: NbuResponseToCurrencyRateModelMapper) :
    BaseMapper<CurrencyDataResult<List<NbuResponse>>, CurrencyDomainResult<List<CurrencyRateModel>>> {

    override fun map(source: CurrencyDataResult<List<NbuResponse>>):
            CurrencyDomainResult<List<CurrencyRateModel>> =
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