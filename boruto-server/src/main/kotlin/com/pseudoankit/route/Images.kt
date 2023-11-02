package com.pseudoankit.route

import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Routing.images() {
    staticResources("/images", "images")
}