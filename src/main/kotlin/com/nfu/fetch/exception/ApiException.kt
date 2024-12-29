package com.nfu.fetch.exception

import com.nfu.fetch.exception.constant.ApiError

open class ApiException(apiError: ApiError): RuntimeException() {

    val status = apiError.status
    val resultCode: String = apiError.resultCode
    val apiError: ApiError = apiError
}