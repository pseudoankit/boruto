package com.pseudoankit.route

import com.pseudoankit.model.ApiResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllHeroes() {
    get("/boruto/heroes") {
        try {
            val pageNo = call.request.queryParameters["page_no"]?.toInt() ?: 1
            require(pageNo in 1..5)

            call.respond("$pageNo")
        } catch (_: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Not a valid page number"),
                status = HttpStatusCode.BadRequest
            )
        } catch (_: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Heroes not found"),
                status = HttpStatusCode.BadRequest
            )
        }
    }
}