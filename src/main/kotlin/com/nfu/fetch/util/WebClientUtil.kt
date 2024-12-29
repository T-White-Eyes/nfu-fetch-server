package com.nfu.fetch.util

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.nfu.fetch.dto.news.naver.NaverErrorResponse
import com.nfu.fetch.exception.ApiException
import io.github.oshai.kotlinlogging.KLogger
import org.springframework.http.HttpStatusCode
import org.springframework.web.reactive.function.client.ClientResponse
import reactor.core.publisher.Mono
import java.util.function.Predicate

fun logErrorResponseAndCreateException(
    logger: KLogger,
    clientResponse: ClientResponse,
    apiException: ApiException
): Mono<ApiException> {
    return clientResponse.bodyToMono(String::class.java)
        .onErrorResume { Mono.empty() }
        .flatMap { responseBody ->
            val errorResponse = convertErrorResponse(responseBody)
            logErrorResponse(logger, errorResponse ?: responseBody)
            Mono.just(apiException)
        }
        .switchIfEmpty(Mono.just(apiException))
}

fun convertErrorResponse(responseBody: String?) = try {
    Gson().fromJson(responseBody, NaverErrorResponse::class.java)
} catch (e: JsonSyntaxException) {
    null
}

fun logErrorResponse(logger: KLogger, response: Any) {
    when (response) {
        is NaverErrorResponse -> {
            logger.error { "[NAVER ERROR] errorMessage: ${response.errorMessage}" }
            logger.error { "[NAVER ERROR] errorCode: ${response.errorCode}" }
        }

        else -> {
            logger.error { response }
        }
    }
}

fun isNot2xxSuccessful(): Predicate<HttpStatusCode> {
    return Predicate<HttpStatusCode> { httpStatus -> !httpStatus.is2xxSuccessful }
}