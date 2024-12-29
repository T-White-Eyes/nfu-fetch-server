package com.nfu.fetch.constant.api.naver

enum class NaverApiSort(
    val value: String
) {

    SIMILARITY_DESC(value = "sim"),
    DATE_DESC(value = "date"),

    DEFAULT(value = SIMILARITY_DESC.value),
    ;


}