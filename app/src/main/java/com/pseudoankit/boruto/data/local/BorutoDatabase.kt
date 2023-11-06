package com.pseudoankit.boruto.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pseudoankit.boruto.data.local.dao.HeroDao
import com.pseudoankit.boruto.data.local.dao.HeroRemoteKeysDao
import com.pseudoankit.boruto.domain.model.Hero
import com.pseudoankit.boruto.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}