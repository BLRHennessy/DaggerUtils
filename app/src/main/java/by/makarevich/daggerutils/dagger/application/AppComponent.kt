package by.makarevich.daggerutils.dagger.application

import android.content.Context
import by.makarevich.daggerutils.DaggerUtilsApplication
import by.makarevich.daggerutils.PreferencesDU
import by.makarevich.daggerutils.utils.CheckInternet
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetworkModule::class, PreferencesModule::class])
@Singleton
interface AppComponent {
    fun prefs(): PreferencesDU
    fun context(): Context
    fun checkInternet(): CheckInternet
    fun inject(target: DaggerUtilsApplication)
}