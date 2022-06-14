package com.serioussem.exchangerate.data.core

sealed class CurrencyDataResult<T>(
    val data: T? = null,
    val message: String? = null,
    val empty: Int? = null
) {
    class Init<T>(emptyState: Int? = null) : CurrencyDataResult<T>(empty = emptyState)
    class Loading<T> : CurrencyDataResult<T>()
    class Success<T>(data: T) : CurrencyDataResult<T>(data = data)
    class Error<T>(message: String, data: T? = null) :
        CurrencyDataResult<T>(data = data, message = message)
}
