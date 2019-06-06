package by.makarevich.daggerutils.interfaces

import by.makarevich.daggerutils.dagger.application.AppComponent

interface App {
    fun getAppComponent(): AppComponent
}