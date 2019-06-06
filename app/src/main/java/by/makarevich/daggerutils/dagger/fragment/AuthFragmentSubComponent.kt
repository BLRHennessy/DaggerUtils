package by.makarevich.daggerutils.dagger.fragment

import by.makarevich.daggerutils.dagger.FragmentScope
import by.makarevich.daggerutils.ui.fragment.AuthFragment
import dagger.Subcomponent

@Subcomponent(modules = [AuthFragmentModule::class])
@FragmentScope
interface AuthFragmentSubComponent {
    fun inject(target: AuthFragment)
}