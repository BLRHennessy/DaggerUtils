package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.ActivityScope
import by.makarevich.daggerutils.ui.activity.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
@ActivityScope
interface MainActivityComponent {
    fun inject(target: MainActivity)
}