package by.makarevich.daggerutils.dagger.application

import android.content.SharedPreferences
import by.makarevich.daggerutils.utils.PreferencesDU
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferencesModule {
    @Provides
    @Singleton
    fun providePrefs(preferences: SharedPreferences): PreferencesDU =
        PreferencesDU(preferences)
}