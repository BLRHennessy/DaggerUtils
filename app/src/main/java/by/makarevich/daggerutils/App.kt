package by.makarevich.daggerutils

import by.makarevich.daggerutils.dagger.application.AppComponent

interface App {
    fun getAppComponent(): AppComponent
}