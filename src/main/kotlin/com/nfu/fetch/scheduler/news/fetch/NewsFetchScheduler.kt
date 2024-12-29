package com.nfu.fetch.scheduler.news.fetch

import com.nfu.fetch.dto.news.naver.NaverNewsRequestParam
import com.nfu.fetch.service.news.fetch.naver.NaverNewsApiService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class NewsFetchScheduler(
    private val naverNewsApiService: NaverNewsApiService
) {

    private val logger = KotlinLogging.logger {}

    @Scheduled(fixedDelay = 999999999999999999)
    fun test() {
        logger.info { "run test" }
        val news = naverNewsApiService.getNews(NaverNewsRequestParam(keyword = "정치"))

        logger.info { news.toString() }

        logger.info { "end test" }
    }
}