package com.nfu.fetch.config.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class GsonConfig {

    @Bean
    fun Gson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .serializeNulls()
            .create()
    }
}