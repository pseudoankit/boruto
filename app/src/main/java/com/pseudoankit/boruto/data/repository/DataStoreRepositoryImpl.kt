package com.pseudoankit.boruto.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.pseudoankit.boruto.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreRepositoryImpl(
    private val context: Context
) : DataStoreRepository {
    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "boruto_prefs")

        object PreferencesKey {
            val onBoarding = booleanPreferencesKey("onboarding_done")
        }
    }

    private val dataStore by lazy { context.dataStore }

    override suspend fun updatedOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoarding] = completed
        }
    }

    override suspend fun isOnboardingDone(): Boolean? {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferencesKey.onBoarding] ?: false
                onBoardingState
            }
            .firstOrNull()
    }
}