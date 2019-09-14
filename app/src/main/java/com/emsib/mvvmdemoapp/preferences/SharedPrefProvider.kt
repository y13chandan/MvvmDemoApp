package com.emsib.mvvmdemoapp.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class SharedPrefProvider(
    context: Context
) {
    private val appContext = context.applicationContext

    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    fun putString(key: String, value: String?) {
        preference.edit().putString(key, value).apply()
    }

    fun putInt(key: String, value: Int) {
        preference.edit().putInt(key, value).apply()
    }

    fun putBool(key: String, value: Boolean) {
        preference.edit().putBoolean(key, value).apply()
    }

    fun getString(key: String, defaultValue: String?): String? {
        return preference.getString(key, defaultValue)
    }

    fun getBool(key: String, defaultValue: Boolean): Boolean {
        return preference.getBoolean(key, defaultValue)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return preference.getInt(key, defaultValue)
    }

}