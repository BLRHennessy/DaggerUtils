package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.GeneralActivityScope
import by.makarevich.daggerutils.dagger.application.AppComponent
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [DialogModule::class])
@GeneralActivityScope
interface ActivityComponent {
    fun plusAuthActivitySubComponent(authActivityModule: AuthActivityModule): AuthActivityComponent
    fun plusMainActivitySubComponent(mainActivityModule: MainActivityModule): MainActivityComponent
}