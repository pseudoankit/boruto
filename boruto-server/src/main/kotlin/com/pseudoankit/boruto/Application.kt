package com.pseudoankit.boruto

import com.pseudoankit.boruto.plugins.configureMonitoring
import com.pseudoankit.boruto.plugins.configureRouting
import com.pseudoankit.boruto.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureRouting()
}
