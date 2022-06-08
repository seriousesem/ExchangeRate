package com.serioussem.exchangerate.data.mappers

import com.serioussem.exchangerate.data.models.DataModelList
import com.serioussem.exchangerate.data.models.DataResult
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.domain.core.DomainModelList
import com.serioussem.exchangerate.domain.core.DomainResult

class DataResultToDomainMapper(private val mapper: DataModelListToDomain) :
    BaseMapper<DataResult<DataModelList>, DomainResult<DomainModelList>> {

    override fun map(source: DataResult<DataModelList>): DomainResult<DomainModelList> =
        when (source) {
            is DataResult.Success -> DomainResult.Success(data = mapper.map(source = source.data as DataModelList))
            is DataResult.Error -> DomainResult.Error(message = source.message as String)
            else -> DomainResult.Loading()
        }
}