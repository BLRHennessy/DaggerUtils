package by.makarevich.daggerutils.dagger.application

import android.content.Context
import by.makarevich.daggerutils.DaggerUtilsApplication
import by.makarevich.daggerutils.utils.ConnectionManager
import by.makarevich.daggerutils.utils.PreferencesDU
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(    modules = [//Указание модулей, которые будут предоставлять зависимости
        AppModule::class,
        NetworkModule::class,
        PreferencesModule::class])
interface AppComponent {
    fun prefs(): PreferencesDU//Предоставление зависимости для dependency компонентов
    fun context(): Context
    fun connectionManager(): ConnectionManager
    fun inject(target: DaggerUtilsApplication)//инъекция для определенного класса
}