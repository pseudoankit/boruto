package com.pseudoankit.boruto.di

import android.content.Context
import androidx.room.Room
import com.pseudoankit.boruto.data.local.BorutoDatabase
import com.pseudoankit.boruto.data.local.dao.HeroDao
import com.pseudoankit.boruto.data.local.dao.HeroRemoteKeysDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): BorutoDatabase {
        return Room.databaseBuilder(
            context,
            BorutoDatabase::class.java,
            "boruto_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideHeroDao(database: BorutoDatabase): HeroDao {
        return database.heroDao()
    }

    @Provides
    @Singleton
    fun provideHeroRemoteKeysDao(database: BorutoDatabase): HeroRemoteKeysDao {
        return database.heroRemoteKeysDao()
    }
}