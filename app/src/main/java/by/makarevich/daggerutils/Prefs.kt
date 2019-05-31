package by.makarevich.daggerutils

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    val PREFS_FILE_NAME = "by.makarevich.daggerutils"
    val USER_KEY = "USER"
    val PASSWORD_KEY = "PASSWORD"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILE_NAME, 0)

    var login: String?
        get() = prefs.getString(USER_KEY, "Ivan")
        set(value) = prefs.edit().putString(USER_KEY, value).apply()


    var password: String?
        get() = prefs.getString(PASSWORD_KEY, "Ivan")
        set(value) = prefs.edit().putString(PASSWORD_KEY, value).apply()
}