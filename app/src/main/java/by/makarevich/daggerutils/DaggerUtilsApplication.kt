package by.makarevich.daggerutils

import android.app.Application
import by.makarevich.daggerutils.dagger.application.AppComponent
import by.makarevich.daggerutils.dagger.application.AppModule
import by.makarevich.daggerutils.dagger.application.DaggerAppComponent
import by.makarevich.daggerutils.interfaces.App

class DaggerUtilsApplication : Application(), App {
    override fun getAppComponent(): AppComponent = appComponent

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }
}