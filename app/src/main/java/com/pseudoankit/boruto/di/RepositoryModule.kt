package com.pseudoankit.boruto.di

import android.content.Context
import com.pseudoankit.boruto.data.local.BorutoDatabase
import com.pseudoankit.boruto.data.local.dao.HeroDao
import com.pseudoankit.boruto.data.local.dao.HeroRemoteKeysDao
import com.pseudoankit.boruto.data.repository.BorutoRepositoryImpl
import com.pseudoankit.boruto.data.repository.DataStoreRepositoryImpl
import com.pseudoankit.boruto.domain.repository.BorutoRepository
import com.pseudoankit.boruto.domain.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreRepo(
        @ApplicationContext context: Context
    ): DataStoreRepository {
        return DataStoreRepositoryImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideBorutoRepo(
        retrofit: Retrofit,
        heroDao: HeroDao,
        heroRemoteKeysDao: HeroRemoteKeysDao,
        database: BorutoDatabase
    ): BorutoRepository {
        return BorutoRepositoryImpl(
            api = retrofit.create(),
            heroDao = heroDao,
            heroRemoteKeysDao = heroRemoteKeysDao,
            database = database
        )
    }
}