package by.makarevich.daggerutils.dagger.utils

import android.content.SharedPreferences

open class Preferences(private val sharedPreferences: SharedPreferences) {

    fun putInt(key: String, value: Int) = sharedPreferences.edit().putInt(key, value).apply()

    fun getInt(key: String, defaultValue: Int): Int = sharedPreferences.getInt(key, defaultValue)

    fun getInt(key: String): Int? {
        return if (hasKey(key)) {
            sharedPreferences.getInt(key, 0)
        } else {
            null
        }
    }


    fun putFloat(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String, defaultValue: Float): Float = sharedPreferences.getFloat(key, defaultValue)

    fun getFloat(key: String): Float? = if (hasKey(key)) {
        sharedPreferences.getFloat(key, 0f)
    } else {
        null
    }


    fun setLong(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    fun getLong(key: String, defaultValue: Long): Long = sharedPreferences.getLong(key, defaultValue)

    fun getLong(key: String): Long? = if (hasKey(key)) {
        sharedPreferences.getLong(key, 0)
    } else {
        null
    }


    fun putString(key: String, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String): String =
        sharedPreferences.getString(key, defaultValue) ?: defaultValue

    fun getString(key: String): String? = if (hasKey(key)) {
        sharedPreferences.getString(key, "")
    } else {
        null
    }


    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean = sharedPreferences.getBoolean(key, defaultValue)

    fun getBoolean(key: String): Boolean? = if (hasKey(key)) {
        sharedPreferences.getBoolean(key, false)
    } else {
        null
    }


    fun hasKey(key: String): Boolean = sharedPreferences.contains(key)

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }

    fun remove(key: String) {
        if (hasKey(key))
            sharedPreferences.edit().remove(key).apply()
    }
}

