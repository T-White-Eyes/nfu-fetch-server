package com.nfu.fetch.service.news

import com.nfu.fetch.repository.news.NewsRepository
import com.nfu.fetch.repository.news.QNewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    private val newsRepository: NewsRepository,
    private val qNewsRepository: QNewsRepository,
) {
}