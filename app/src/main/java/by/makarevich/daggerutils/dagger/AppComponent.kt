package by.makarevich.daggerutils.dagger

import by.makarevich.daggerutils.AppDaggerUtils
import by.makarevich.daggerutils.Prefs
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun prefs(): Prefs
    fun inject(target: AppDaggerUtils)
}