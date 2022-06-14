package com.serioussem.exchangerate.domain.core

sealed class CurrencyDomainResult<T>(
    val data: T? = null,
    val message: String? = null,
    val empty: Int? = null
) {
    class Init<T>(emptyState: Int? = null) : CurrencyDomainResult<T>(empty = emptyState)
    class Loading<T> : CurrencyDomainResult<T>()
    class Success<T>(data: T) : CurrencyDomainResult<T>(data = data)
    class Error<T>(message: String, data: T? = null) :
        CurrencyDomainResult<T>(data = data, message = message)
}
