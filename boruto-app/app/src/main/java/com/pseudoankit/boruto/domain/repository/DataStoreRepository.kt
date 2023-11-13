package com.pseudoankit.boruto.domain.repository

interface DataStoreRepository {
    suspend fun updatedOnBoardingState(completed: Boolean)
    suspend fun isOnboardingDone(): Boolean?
}
