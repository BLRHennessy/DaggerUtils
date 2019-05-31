package by.makarevich.daggerutils.dagger

import by.makarevich.daggerutils.Prefs
import by.makarevich.daggerutils.ui.PresenterLogin
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
    @Provides
    @PresenterScope
    fun providePresenter(prefs: Prefs): PresenterLogin = PresenterLogin(prefs)
}