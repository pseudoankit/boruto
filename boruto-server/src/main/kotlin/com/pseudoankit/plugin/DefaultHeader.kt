package com.pseudoankit.plugin

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*
import java.time.Duration

fun Application.configureDefaultHeader() {
    install(DefaultHeaders) {
        val oneYearInSeconds = Duration.ofDays(365).seconds
        header(HttpHeaders.CacheControl, "public, max-age=$oneYearInSeconds, immutable")
    }
}
