package xyz.tberghuis.floatingtimer.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(
  name = "user_preferences",
)

class PreferencesRepository(private val dataStore: DataStore<Preferences>) {
  val vibrationFlow: Flow<Boolean> = dataStore.data.map { preferences ->
    preferences[booleanPreferencesKey("vibration")] ?: true
  }

  suspend fun updateVibration(vibration: Boolean) {
    dataStore.edit { preferences ->
      preferences[booleanPreferencesKey("vibration")] = vibration
    }
  }

  val soundFlow: Flow<Boolean> = dataStore.data.map { preferences ->
    preferences[booleanPreferencesKey("sound")] ?: true
  }

  suspend fun updateSound(sound: Boolean) {
    dataStore.edit { preferences ->
      preferences[booleanPreferencesKey("sound")] = sound
    }
  }

  suspend fun checkFirstRun(): Boolean {
    return dataStore.data.map { preferences ->
      preferences[booleanPreferencesKey("first_run")] ?: true
    }.first()
  }

  suspend fun setFirstRunFalse() {
    dataStore.edit { preferences ->
      preferences[booleanPreferencesKey("first_run")] = false
    }
  }


  val haloColourPurchasedFlow: Flow<Boolean> = dataStore.data.map { preferences ->
    preferences[booleanPreferencesKey("halo_colour_purchased")] ?: false
  }

  suspend fun updateHaloColourPurchased(purchased: Boolean) {
    dataStore.edit { preferences ->
      preferences[booleanPreferencesKey("halo_colour_purchased")] = purchased
    }
  }


}