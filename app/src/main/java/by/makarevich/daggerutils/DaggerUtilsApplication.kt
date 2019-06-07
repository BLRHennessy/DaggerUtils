package by.makarevich.daggerutils

import android.app.Application
import by.makarevich.daggerutils.dagger.application.AppComponent
import by.makarevich.daggerutils.dagger.application.AppModule
import by.makarevich.daggerutils.dagger.application.DaggerAppComponent
import by.makarevich.daggerutils.interfaces.App

class DaggerUtilsApplication : Application(), App {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // DaggerAppComponent - cгенерированный библиотекой класс, отвечающий за построение графа зависимосней и их инъекцний.
        //Его создает AppComponent, доступен при успешной компиляции.
        appComponent = DaggerAppComponent//инициализация компонента
            .builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)//Инъекция зависимостей в данный класс
    }

    override fun getAppComponent(): AppComponent = appComponent
}