package com.nfu.fetch.config.api.news

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "news-api.naver")
class NaverNewsApiSetting(
    val clientIdHeaderName: String,
    val clientId: String,
    val clientSecret: String,
    val clientSecretHeaderName: String,
    val baseUrl: String,
)