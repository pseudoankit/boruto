package com.pseudoankit.repository

import com.pseudoankit.model.ApiResponse

interface HeroRepository {

    suspend fun getAllHeroes(page: Int, count: Int): ApiResponse
    suspend fun searchHeroes(query: String?): ApiResponse
}