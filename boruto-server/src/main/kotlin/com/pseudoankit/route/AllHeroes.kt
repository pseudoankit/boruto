package com.pseudoankit.route

import com.pseudoankit.model.ApiResponse
import com.pseudoankit.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroes() {
    val repository by inject<HeroRepository>()

    get("/boruto/heroes") {
        try {
            val pageNo = call.request.queryParameters["page_no"]?.toInt() ?: 1

            val response = repository.getAllHeroes(pageNo, 3)

            call.respond(message = response, status = HttpStatusCode.OK)
        } catch (_: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Not a valid page number"),
                status = HttpStatusCode.BadRequest
            )
        } catch (_: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Page not found."),
                status = HttpStatusCode.NotFound
            )
        } catch (_: Exception) {
            call.respond(
                message = ApiResponse(success = false, message = "Unknown Error"),
                status = HttpStatusCode.InternalServerError
            )
        }
    }
}
