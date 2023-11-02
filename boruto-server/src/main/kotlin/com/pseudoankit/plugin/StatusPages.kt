package com.pseudoankit.plugin

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import javax.naming.AuthenticationException

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, statusCode ->
            call.respond(
                message = "Page not found.",
                status = statusCode
            )
        }
        exception<AuthenticationException> { call, _ ->
            call.respond(
                message = "User not logged in",
                status = HttpStatusCode.Unauthorized
            )
        }
    }
}
