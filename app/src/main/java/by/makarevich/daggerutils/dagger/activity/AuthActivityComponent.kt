package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.SubPresenterComponent
import by.makarevich.daggerutils.dagger.SubPresenterModule
import by.makarevich.daggerutils.dagger.application.AppComponent
import by.makarevich.daggerutils.ui.AuthActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [AuthActivityModule::class])
@ActivityScope
interface AuthActivityConponent {
    fun inject(target: AuthActivity)
    fun addSubPresenterComponent(module: SubPresenterModule): SubPresenterComponent
}