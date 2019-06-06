package by.makarevich.daggerutils.dagger.application

import android.content.Context
import by.makarevich.daggerutils.utils.ConnectionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCheckInternet(context: Context): ConnectionManager = ConnectionManager(context)
}