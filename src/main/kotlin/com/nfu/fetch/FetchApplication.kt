package com.nfu.fetch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FetchApplication

fun main(args: Array<String>) {
    runApplication<FetchApplication>(*args)
}
