package by.makarevich.daggerutils.dagger

import android.content.Context
import by.makarevich.daggerutils.Prefs
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun providePrefs(): Prefs = Prefs(context)
}
