package com.nfu.fetch.entity.news

import com.nfu.fetch.entity.base.CreatedAndUpdatedTimeEntity
import jakarta.persistence.*
import java.math.BigInteger
import java.time.OffsetDateTime

@Entity
@Table(name = "news")
class News(

    @Column(name = "category_id")
    val categoryId: Long,

    @Column(name = "news_platform_type_id")
    val newsPlatformTypeId: Short,

    @Column(name = "author", length = 63)
    val author: String,

    @Column(name = "description", length = 2047)
    val description: String,

    @Column(name = "title", length = 1023)
    val title: String,

    @Column(name = "content", columnDefinition = "TEXT")
    val content: String,

    @Column(name = "thumbnail_url", length = 1023)
    val thumbnailUrl: String,

    @Column(name = "video_url", length = 1023)
    val videoUrl: String? = null,

    @Column(name = "original_url", length = 1023)
    val originalUrl: String,

    @Column(name = "published_at")
    val publishedAt: OffsetDateTime
): CreatedAndUpdatedTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    val id: BigInteger = BigInteger.ONE
}