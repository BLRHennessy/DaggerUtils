package by.makarevich.daggerutils.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import by.makarevich.daggerutils.R
import by.makarevich.daggerutils.dagger.activity.AuthActivityModule
import by.makarevich.daggerutils.dagger.fragment.AuthFragmentModule
import by.makarevich.daggerutils.interfaces.IPresenterLogin
import by.makarevich.daggerutils.ui.PresenterLogin
import by.makarevich.daggerutils.ui.activity.AuthActivity
import by.makarevich.daggerutils.ui.activity.BaseActivity
import by.makarevich.daggerutils.ui.activity.MainActivity
import javax.inject.Inject

class AuthFragment : AbstractFragment(), IPresenterLogin {

    @Inject
    lateinit var presenter: PresenterLogin

    var login: EditText? = null
    var password: EditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val authActivityComponent =
            (context as BaseActivity).activityComponent?.plusAuthActivitySubComponent(AuthActivityModule())
        val authFragmentComponent =
            authActivityComponent?.plusAuthFragmentSubComponent(AuthFragmentModule())
        authFragmentComponent?.inject(this)
        val v = inflater.inflate(R.layout.fragment_auth, container, false)
        login = v.findViewById(R.id.login)
        password = v.findViewById(R.id.password)
        v.findViewById<TextView>(R.id.registration).setOnClickListener {
            (context as AuthActivity).showRegistrationFragment()
        }
        v.findViewById<TextView>(R.id.ok).setOnClickListener {
            presenter.checkCredantials(login?.text.toString(), password?.text.toString())
        }
        presenter.onAttachedToWindow(this)
        return v
    }

    override fun showDialog(text: String) {
        (context as AuthActivity).showDialog(text)
    }


    override fun login() {
        MainActivity.startActivity((context as AuthActivity))
    }
}