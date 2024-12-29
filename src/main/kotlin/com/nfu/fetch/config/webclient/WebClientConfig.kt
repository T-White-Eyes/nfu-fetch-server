package com.nfu.fetch.config.webclient

import com.nfu.fetch.config.api.news.NaverNewsApiSetting
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.*
import reactor.core.publisher.Mono
import java.util.function.Consumer

@Component
class WebClientConfig(
    private val naverNewsApiSetting: NaverNewsApiSetting,
) {

    private val logger = KotlinLogging.logger {}

    companion object {
        private const val UTF_8 = "UTF-8"
    }

    @Bean
    @Qualifier(value = "naverApiWebClient")
    fun naverApiWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(naverNewsApiSetting.baseUrl)
            .defaultHeaders { headers ->
                headers[naverNewsApiSetting.clientIdHeaderName] = naverNewsApiSetting.clientId
                headers[naverNewsApiSetting.clientSecretHeaderName] = naverNewsApiSetting.clientSecret
                headers[HttpHeaders.CONTENT_TYPE] = listOf(
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE
                )
                headers[HttpHeaders.ACCEPT_CHARSET] = UTF_8
            }
            .filters { exchangeFilterFunctions ->
                exchangeFilterFunctions.add(logRequest())
                exchangeFilterFunctions.add(logResponse())
            }
            .build()
    }

    private fun logRequest(): ExchangeFilterFunction {
        return ExchangeFilterFunction.ofRequestProcessor { clientRequest: ClientRequest ->
            logger.debug {"Request: ${clientRequest.method()} ${clientRequest.url()}" }
            clientRequest.headers()
                .forEach { name: String?, values: List<String?> ->
                    values.forEach(
                        Consumer<String?> { value: String? ->
                            logger.debug { "$name = $value" }
                        })
                }
            Mono.just<ClientRequest>(clientRequest)
        }
    }

    private fun logResponse(): ExchangeFilterFunction {
        return ExchangeFilterFunction.ofResponseProcessor { clientResponse: ClientResponse ->
            logger.debug {"Response status: ${clientResponse.statusCode()}" }
            clientResponse.headers().asHttpHeaders()
                .forEach { name: String?, values: List<String?> ->
                    values.forEach(
                        Consumer<String?> { value: String? ->
                            logger.debug { "$name = $value" }
                        })
                }
            Mono.just<ClientResponse>(clientResponse)
        }
    }
}