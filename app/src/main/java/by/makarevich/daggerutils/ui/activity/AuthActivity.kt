package by.makarevich.daggerutils.ui.activity

import android.os.Bundle
import by.makarevich.daggerutils.R
import by.makarevich.daggerutils.dagger.activity.AuthActivityComponent
import by.makarevich.daggerutils.dagger.activity.DaggerAuthActivityComponent
import by.makarevich.daggerutils.interfaces.IPresenter
import by.makarevich.daggerutils.ui.fragment.AbstractFragment
import by.makarevich.daggerutils.ui.fragment.AuthFragment
import by.makarevich.daggerutils.ui.fragment.RegistrationFragment
import by.makarevich.daggerutils.utils.DialogManager
import javax.inject.Inject

class AuthActivity : BaseActivity(), IPresenter {

    @Inject
    lateinit var authFragment: AuthFragment
    @Inject
    lateinit var registrationFragment: RegistrationFragment
    @Inject
    lateinit var dialogManager: DialogManager

    lateinit var authActivityComponent: AuthActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        authActivityComponent = DaggerAuthActivityComponent.builder().appComponent(appComponent).build()
        authActivityComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showAuthFragment()
    }

    private fun showSomeFragment(fragment: AbstractFragment) {
        showFragment(fragment, R.id.fragment_container, 0, 0)
    }

    fun showAuthFragment() {
        showSomeFragment(authFragment)
    }

    fun showRegistrationFragment() {
        showSomeFragment(registrationFragment)
    }

    override fun showDialog(text: String) {
        dialogManager.showDialog(this, text)
    }
}
