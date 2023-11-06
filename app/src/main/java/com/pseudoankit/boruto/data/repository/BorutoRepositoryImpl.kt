package com.pseudoankit.boruto.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.room.RoomDatabase
import com.pseudoankit.boruto.data.local.dao.HeroDao
import com.pseudoankit.boruto.data.local.dao.HeroRemoteKeysDao
import com.pseudoankit.boruto.data.paging_source.HeroRemoteMediator
import com.pseudoankit.boruto.data.paging_source.SearchHeroesSource
import com.pseudoankit.boruto.data.remote.BorutoApi
import com.pseudoankit.boruto.domain.model.Hero
import com.pseudoankit.boruto.domain.repository.BorutoRepository
import kotlinx.coroutines.flow.Flow

class BorutoRepositoryImpl(
    private val api: BorutoApi,
    private val heroDao: HeroDao,
    private val heroRemoteKeysDao: HeroRemoteKeysDao,
    private val database: RoomDatabase
) : BorutoRepository {
    @OptIn(ExperimentalPagingApi::class)
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = 3),
            remoteMediator = HeroRemoteMediator(
                borutoApi = api,
                borutoDatabase = database,
                heroDao = heroDao,
                heroRemoteKeysDao = heroRemoteKeysDao
            ),
            pagingSourceFactory = { heroDao.getAllHeroes() }
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = 3),
            pagingSourceFactory = {
                SearchHeroesSource(borutoApi = api, query = query)
            }
        ).flow
    }

    override suspend fun getHeroForId(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}