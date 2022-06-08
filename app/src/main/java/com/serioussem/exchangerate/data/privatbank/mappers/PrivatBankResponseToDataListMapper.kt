package com.serioussem.exchangerate.data.privatbank.mappers

import com.serioussem.exchangerate.data.models.DataModel
import com.serioussem.exchangerate.data.models.DataModelList
import com.serioussem.exchangerate.data.privatbank.model.PrivatBankResponse
import com.serioussem.exchangerate.data.core.BaseMapper

class PrivatBankResponseToDataListMapper(private val mapper: PrivatBankModelToDataMapper) :
    BaseMapper<PrivatBankResponse, DataModelList> {
    override fun map(source: PrivatBankResponse): DataModelList {
        val dataModelList = mutableListOf<DataModel>()
        source.privatBankResponse.forEach { privatBankModel ->
            dataModelList.add(mapper.map(privatBankModel))
        }
        return  DataModelList(dataModelList = dataModelList)
    }
}