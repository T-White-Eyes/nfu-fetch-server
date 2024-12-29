package com.nfu.fetch.exception.response

import com.nfu.fetch.exception.constant.ApiError

class ApiErrorResponse(
    val resultCode: String,
    val message: String?,
) {

    constructor(apiError: ApiError): this(apiError.resultCode, apiError.message)
}