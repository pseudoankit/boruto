package com.pseudoankit.plugin

import com.pseudoankit.route.getAllHeroes
import com.pseudoankit.route.images
import com.pseudoankit.route.root
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        getAllHeroes()
        images()
    }
}
