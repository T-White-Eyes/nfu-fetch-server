package com.nfu.fetch.exception.handler

import com.nfu.fetch.exception.ApiException
import com.nfu.fetch.exception.response.ApiErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ApiExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(ApiException::class)
    fun handle(ex: ApiException): ResponseEntity<Any> {
        return ResponseEntity(
            ApiErrorResponse(ex.apiError),
            HttpStatus.resolve(ex.status)!!
        )
    }
}