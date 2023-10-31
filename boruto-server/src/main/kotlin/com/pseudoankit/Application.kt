package com.pseudoankit

import com.pseudoankit.plugins.configureMonitoring
import com.pseudoankit.plugins.configureRouting
import com.pseudoankit.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureRouting()
}
