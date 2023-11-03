package com.pseudoankit.repository

import com.pseudoankit.model.ApiResponse
import com.pseudoankit.model.Hero

interface HeroRepository {

    val allHeroes: List<Hero>

    suspend fun getAllHeroes(page: Int, count: Int): ApiResponse
    suspend fun searchHeroes(query: String?): ApiResponse
}