package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.application.AppComponent
import dagger.Component
import javax.inject.Scope

@Component(dependencies = [AppComponent::class])
@ActivityScope
interface ActivityComponent {
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope