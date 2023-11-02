package com.pseudoankit.route

import com.pseudoankit.model.ApiResponse
import com.pseudoankit.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes() {
    val repository by inject<HeroRepository>()

    get("/boruto/heroes/search") {
        try {
            val query = call.request.queryParameters["query"]

            val response = repository.searchHeroes(query)
            call.respond(message = response, status = HttpStatusCode.OK)
        } catch (_: Exception) {
            call.respond(
                message = ApiResponse(success = false, message = "Unknown Error"),
                status = HttpStatusCode.InternalServerError
            )
        }
    }
}
