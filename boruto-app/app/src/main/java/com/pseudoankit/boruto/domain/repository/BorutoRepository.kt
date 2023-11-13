package com.pseudoankit.boruto.domain.repository

import androidx.paging.PagingData
import com.pseudoankit.boruto.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface BorutoRepository {
    fun getAllHeroes(): Flow<PagingData<Hero>>

    fun searchHeroes(query: String): Flow<PagingData<Hero>>

    suspend fun getHeroForId(heroId: Int): Hero
}