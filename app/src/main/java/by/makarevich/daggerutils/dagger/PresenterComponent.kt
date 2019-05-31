package by.makarevich.daggerutils.dagger

import by.makarevich.daggerutils.ui.MainActivity
import dagger.Component
import javax.inject.Scope

@Component(dependencies = [AppComponent::class], modules = [PresenterModule::class])
@PresenterScope
interface PresenterComponent {
    fun inject(target: MainActivity)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PresenterScope