package by.makarevich.daggerutils.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import by.makarevich.daggerutils.R
import by.makarevich.daggerutils.dagger.fragment.RegistrationFragmentModule
import by.makarevich.daggerutils.interfaces.IPresenterRegistration
import by.makarevich.daggerutils.ui.PresenterRegistration
import by.makarevich.daggerutils.ui.activity.AuthActivity
import javax.inject.Inject

class RegistrationFragment : AbstractFragment(), IPresenterRegistration {

    @Inject
    lateinit var presenter: PresenterRegistration

    private var login: EditText? = null
    private var password: EditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (context as AuthActivity)
            .authActivityComponent
            .plusRegistrationFragmentSubComponent(RegistrationFragmentModule())
            .inject(this)
        presenter.onAttachedToWindow(this)
        val v = inflater.inflate(R.layout.fragment_registration, container, false)
        login = v.findViewById(R.id.login)
        password = v.findViewById(R.id.password)
        v.findViewById<TextView>(R.id.sign_up_ok).setOnClickListener {
            presenter.saveCredantials(login?.text.toString(), password?.text.toString())
        }
        return v
    }

    override fun register() {
        (context as AuthActivity).showAuthFragment()
    }

    override fun showDialog(text: String) {
        (context as AuthActivity).showDialog(text)
    }
}