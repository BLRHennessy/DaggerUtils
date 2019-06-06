package by.makarevich.daggerutils.utils

import android.content.SharedPreferences
import by.makarevich.daggerutils.utils.Preferences

class PreferencesDU(sharedPreferences: SharedPreferences) {
    private val preferences = Preferences(sharedPreferences)

    private val USER_KEY = "USER"
    private val PASSWORD_KEY = "PASSWORD"

    var login: String?
        get() = preferences.getString(USER_KEY)
        set(value) = preferences.putString(USER_KEY, value)

    var password: String?
        get() = preferences.getString(PASSWORD_KEY, "password")
        set(value) = preferences.putString(PASSWORD_KEY, value)
}