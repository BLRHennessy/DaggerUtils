package by.makarevich.daggerutils

import android.app.Application
import by.makarevich.daggerutils.dagger.*

class AppDaggerUtils : Application() {

    private lateinit var appComponent: AppComponent
    lateinit var presenterComponent: PresenterComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
        presenterComponent = DaggerPresenterComponent
            .builder()
            .appComponent(appComponent)
            .presenterModule(PresenterModule())
            .build()
    }
}