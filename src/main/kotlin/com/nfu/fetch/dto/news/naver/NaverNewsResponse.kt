package com.nfu.fetch.dto.news.naver

import com.fasterxml.jackson.annotation.JsonProperty

class NaverNewsResponse(

    @JsonProperty(value = "lastBuildDate")
    val lastBuildDateTime: String,

    @JsonProperty(value = "total")
    val totalCount: Long,

    @JsonProperty(value = "start")
    val offset: Int,

    @JsonProperty(value = "display")
    val size: Int,

    @JsonProperty(value = "items")
    val items: List<Item>,
) {

    class Item(

        @JsonProperty(value = "title")
        val title: String,

        @JsonProperty(value = "originallink")
        val originalLink: String,

        @JsonProperty(value = "link")
        val link: String,

        @JsonProperty(value = "description")
        val description: String,

        @JsonProperty(value = "pubDate")
        val publishedDateTime: String
    ) {
        override fun toString(): String {
            return "Item(title='$title', originalLink='$originalLink', link='$link', description='$description', publishedDateTime='$publishedDateTime')"
        }
    }

    override fun toString(): String {
        return "NaverNewsResponse(lastBuildDateTime='$lastBuildDateTime', totalCount=$totalCount, offset=$offset, size=$size, items=$items)"
    }

}