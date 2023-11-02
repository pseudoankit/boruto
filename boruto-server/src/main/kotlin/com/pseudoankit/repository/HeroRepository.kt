package com.pseudoankit.repository

import com.pseudoankit.model.ApiResponse

interface HeroRepository {

    suspend fun getAllHeroes(page: Int): ApiResponse
    suspend fun searchHeroes(name: String): ApiResponse
}