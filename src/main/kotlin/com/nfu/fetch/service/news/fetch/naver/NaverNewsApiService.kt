package com.nfu.fetch.service.news.fetch.naver

import com.nfu.fetch.constant.api.naver.NaverApiQueryParam
import com.nfu.fetch.constant.api.naver.NaverApiSort
import com.nfu.fetch.dto.news.naver.NaverNewsRequestParam
import com.nfu.fetch.dto.news.naver.NaverNewsResponse
import com.nfu.fetch.exception.ApiException
import com.nfu.fetch.exception.constant.ApiError
import com.nfu.fetch.util.isNot2xxSuccessful
import com.nfu.fetch.util.logErrorResponseAndCreateException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class NaverNewsApiService(
    @Qualifier("naverApiWebClient") private val naverApiWebClient: WebClient
) {

    private val logger = KotlinLogging.logger {}

    fun getNews(requestParam: NaverNewsRequestParam): NaverNewsResponse {
        return naverApiWebClient
            .get()
            .uri { uriBuilder -> uriBuilder.queryParams(requestParam.toMap()).build() }
            .retrieve()
            .onStatus(isNot2xxSuccessful()) { clientResponse ->
                logErrorResponseAndCreateException(
                    logger = logger,
                    clientResponse = clientResponse,
                    apiException = ApiException(ApiError.SERVER_ERROR)
                )
            }
            .bodyToMono(NaverNewsResponse::class.java)
            .block() ?: throw ApiException(ApiError.SERVER_ERROR)
    }
}