package com.atom.myapp.Data


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserMail(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences>
                by preferencesDataStore("User_Mail")
        val USER_MAIL = stringPreferencesKey("user_mail")
        val USER_PASS = stringPreferencesKey("user_pass")
    }
    val getMail: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_MAIL] ?: ""
        }

    val getPass: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[USER_PASS] ?: ""
    }

    suspend fun saveMail(email:String, pass: String){
        context.dataStore.edit { preferences ->
            preferences[USER_MAIL] = email
            preferences[USER_PASS] = pass
        }
    }
}