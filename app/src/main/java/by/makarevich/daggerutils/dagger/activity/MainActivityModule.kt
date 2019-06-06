package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.ActivityScope
import by.makarevich.daggerutils.ui.fragment.AuthFragment
import by.makarevich.daggerutils.ui.fragment.RegistrationFragment
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideAuthFragment(): AuthFragment = AuthFragment()

    @Provides
    @ActivityScope
    fun provideRegistrationFragment(): RegistrationFragment = RegistrationFragment()
}