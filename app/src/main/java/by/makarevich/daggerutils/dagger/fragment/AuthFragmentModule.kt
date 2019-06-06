package by.makarevich.daggerutils.dagger.fragment

import by.makarevich.daggerutils.PreferencesDU
import by.makarevich.daggerutils.dagger.FragmentScope
import by.makarevich.daggerutils.ui.PresenterLogin
import dagger.Module
import dagger.Provides

@Module
class AuthFragmentModule {

    @Provides
    @FragmentScope
    fun providePresenter(prefs: PreferencesDU): PresenterLogin = PresenterLogin(prefs)
}