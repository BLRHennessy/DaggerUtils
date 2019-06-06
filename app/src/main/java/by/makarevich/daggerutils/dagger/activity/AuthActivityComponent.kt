package by.makarevich.daggerutils.dagger.activity

import by.makarevich.daggerutils.dagger.ActivityScope
import by.makarevich.daggerutils.dagger.fragment.AuthFragmentModule
import by.makarevich.daggerutils.dagger.fragment.AuthFragmentSubComponent
import by.makarevich.daggerutils.dagger.fragment.RegistrationFragmentModule
import by.makarevich.daggerutils.dagger.fragment.RegistrationFragmentSubComponent
import by.makarevich.daggerutils.ui.activity.AuthActivity
import dagger.Subcomponent

@Subcomponent(modules = [AuthActivityModule::class])
@ActivityScope
interface AuthActivityComponent {
    fun plusAuthFragmentSubComponent(authFragmentModule: AuthFragmentModule): AuthFragmentSubComponent
    fun plusRegistrationFragmentSubComponent(registrationFragmentModule: RegistrationFragmentModule): RegistrationFragmentSubComponent
    fun inject(target: AuthActivity)
}