package com.pseudoankit.model

import kotlinx.serialization.Serializable

@Serializable
data class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val families: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>,
)
