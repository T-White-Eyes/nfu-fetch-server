package com.nfu.fetch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
@ConfigurationPropertiesScan
class FetchApplication

fun main(args: Array<String>) {
    runApplication<FetchApplication>(*args)
}
