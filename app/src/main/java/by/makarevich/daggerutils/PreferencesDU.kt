package by.makarevich.daggerutils

import android.content.SharedPreferences
import by.makarevich.daggerutils.dagger.utils.Preferences

class PreferencesDU(preferences: SharedPreferences) {
    private val preferences = Preferences(preferences)

    private val USER_KEY = "USER"
    private val PASSWORD_KEY = "PASSWORD"

    var login: String?
        get() = preferences.getString(USER_KEY)
        set(value) = preferences.putString(USER_KEY, value)

    var password: String?
        get() = preferences.getString(PASSWORD_KEY, "Ivan")
        set(value) = preferences.putString(PASSWORD_KEY, value)
}