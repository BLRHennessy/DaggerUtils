package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.ActivityScope
import by.makarevich.daggerutils.dagger.application.AppComponent
import by.makarevich.daggerutils.ui.activity.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [DialogModule::class, MainActivityModule::class])
@ActivityScope
interface MainActivityComponent{
    fun inject(target: MainActivity)
}