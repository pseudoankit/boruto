package com.pseudoankit.boruto.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero_remote_entity")
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)
