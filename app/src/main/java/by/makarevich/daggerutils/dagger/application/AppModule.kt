package by.makarevich.daggerutils.dagger.application

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module//Класс предоставляющий зависимости
class AppModule(private val application: Application) {

    @Provides//Метод внутри @Module, предоставляющий зависимость
    @Singleton//default Scope
    fun provideContext(): Context = application// предоставление зависимости

    @Provides
    @Singleton
    fun providePrefs(): SharedPreferences =
        application.getSharedPreferences("by.makarevich.daggerutils", Context.MODE_PRIVATE)
}
