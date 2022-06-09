package com.serioussem.exchangerate.domain.privatbank.usecase

import com.serioussem.exchangerate.domain.core.BaseUseCase
import com.serioussem.exchangerate.domain.core.DomainModel
import com.serioussem.exchangerate.domain.core.DomainModelList
import com.serioussem.exchangerate.domain.core.DomainResult
import com.serioussem.exchangerate.domain.privatbank.repository.PrivatBankRepository

class PrivatBankCurrencyRate(private val repository: PrivatBankRepository) :
    BaseUseCase<DomainResult<DomainModelList>> {

    override suspend fun fetchCurrencyRate() = repository.fetchCurrencyRate()
}