package com.nfu.fetch.dto.news.naver

import com.nfu.fetch.constant.api.naver.NaverApiQueryParam
import com.nfu.fetch.constant.api.naver.NaverApiSort
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

class NaverNewsRequestParam(
    private val keyword: String,
    private var size: Int = NaverApiQueryParam.DEFAULT_SIZE,
    private var offset: Int = NaverApiQueryParam.DEFAULT_OFFSET,
    private val sort: NaverApiSort = NaverApiSort.DEFAULT,
) {

    init {
        if (this.size > NaverApiQueryParam.MAX_SIZE) {
            this.size = NaverApiQueryParam.MAX_SIZE
        }

        if (this.offset > NaverApiQueryParam.MAX_OFFSET) {
            this.offset = NaverApiQueryParam.MAX_OFFSET
        }
    }

    fun toMap(): MultiValueMap<String, String> {
        val params = LinkedMultiValueMap<String, String>()
        params[NaverApiQueryParam.KEYWORD_PARAM_NAME] = this.keyword
        params[NaverApiQueryParam.SIZE_PARAM_NAME] = this.size.toString()
        params[NaverApiQueryParam.OFFSET_PARAM_NAME] = this.offset.toString()
        params[NaverApiQueryParam.SORT_PARAM_NAME] = this.sort.value

        return params
    }
}