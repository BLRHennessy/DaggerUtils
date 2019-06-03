package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.PreferencesDU
import by.makarevich.daggerutils.ui.PresenterLogin
import dagger.Module
import dagger.Provides

@Module
class AuthActivityModule {
    @Provides
    @ActivityScope
    fun providePresenter(prefs: PreferencesDU): PresenterLogin = PresenterLogin(prefs)
}