package by.makarevich.daggerutils.dagger.application

import android.content.Context
import by.makarevich.daggerutils.DaggerUtilsApplication
import by.makarevich.daggerutils.utils.ConnectionManager
import by.makarevich.daggerutils.utils.PreferencesDU
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(    modules = [
        AppModule::class,
        NetworkModule::class,
        PreferencesModule::class])
interface AppComponent {
    fun prefs(): PreferencesDU
    fun context(): Context
    fun connectionManager(): ConnectionManager
    fun inject(target: DaggerUtilsApplication)
}