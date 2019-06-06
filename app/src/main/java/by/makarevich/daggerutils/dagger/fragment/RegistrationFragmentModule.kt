package by.makarevich.daggerutils.dagger.fragment

import by.makarevich.daggerutils.PreferencesDU
import by.makarevich.daggerutils.dagger.FragmentScope
import by.makarevich.daggerutils.ui.PresenterLogin
import by.makarevich.daggerutils.ui.PresenterRegistration
import dagger.Module
import dagger.Provides

@Module
class RegistrationFragmentModule {

    @Provides
    @FragmentScope
    fun providePresenter(prefs: PreferencesDU): PresenterRegistration = PresenterRegistration(prefs)
}