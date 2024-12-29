package com.nfu.fetch.exception.constant

import org.springframework.http.HttpStatus

enum class ApiError(
    val status: Int,
    val resultCode: String,
    val message: String
) {

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "-1", "Server Error"),

   ;
}