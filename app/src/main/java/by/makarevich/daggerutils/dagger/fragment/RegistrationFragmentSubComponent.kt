package by.makarevich.daggerutils.dagger.fragment

import by.makarevich.daggerutils.dagger.FragmentScope
import by.makarevich.daggerutils.ui.fragment.RegistrationFragment
import dagger.Subcomponent

@Subcomponent(modules = [RegistrationFragmentModule::class])
@FragmentScope
interface RegistrationFragmentSubComponent {
    fun inject(target: RegistrationFragment)
}