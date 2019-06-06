package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.ActivityScope
import by.makarevich.daggerutils.dagger.application.AppComponent
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [DialogModule::class])
@ActivityScope
interface ActivityComponent