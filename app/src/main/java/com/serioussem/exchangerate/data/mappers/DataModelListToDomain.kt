package com.serioussem.exchangerate.data.mappers

import com.serioussem.exchangerate.data.models.DataModelList
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.domain.core.DomainModel
import com.serioussem.exchangerate.domain.core.DomainModelList

class DataModelListToDomain(private val mapper: DataModelToDomain):
    BaseMapper<DataModelList, DomainModelList> {
    override fun map(source: DataModelList): DomainModelList {
        val domainModelList = mutableListOf<DomainModel>()
        source.dataModelList.forEach { dataModel ->
            domainModelList.add(mapper.map(dataModel))
        }
        return DomainModelList(domainModelList = domainModelList)
    }
}