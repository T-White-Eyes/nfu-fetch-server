package com.nfu.fetch.repository.news

import com.nfu.fetch.entity.news.News
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigInteger

interface NewsRepository: JpaRepository<News, BigInteger> {
}