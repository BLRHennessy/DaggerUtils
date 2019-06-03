package by.makarevich.daggerutils.dagger.application

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun providePrefs(): SharedPreferences =
        application.getSharedPreferences("by.makarevich.daggerutils", Context.MODE_PRIVATE)
}
