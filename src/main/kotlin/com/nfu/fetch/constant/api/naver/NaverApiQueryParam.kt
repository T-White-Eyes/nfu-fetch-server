package com.nfu.fetch.constant.api.naver

object NaverApiQueryParam {

    const val KEYWORD_PARAM_NAME = "query"
    const val SIZE_PARAM_NAME = "display"
    const val OFFSET_PARAM_NAME = "start"
    const val SORT_PARAM_NAME = "sort"

    const val DEFAULT_SIZE = 10
    const val DEFAULT_OFFSET = 1

    const val MAX_SIZE: Int = 100
    const val MAX_OFFSET: Int = 1000
}