package com.nfu.fetch.repository.news

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QNewsRepository(
    private val queryFactory: JPAQueryFactory,
) {
}