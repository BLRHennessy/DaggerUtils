package by.makarevich.daggerutils.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import by.makarevich.daggerutils.AppDaggerUtils
import by.makarevich.daggerutils.Prefs
import by.makarevich.daggerutils.R
import by.makarevich.daggerutils.interfaces.IPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IPresenter {
    @Inject
    lateinit var presenter: PresenterLogin
    @Inject
    lateinit var prefs: Prefs

    private val etLogin: TextView by lazy { findViewById<TextView>(R.id.login) }
    private val etPassword: TextView by lazy { findViewById<TextView>(R.id.password) }
    private val ok: TextView by lazy { findViewById<TextView>(R.id.ok) }

    override fun getText(): String = presenter.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as AppDaggerUtils).presenterComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttachedToWindow(this)
        etLogin.text = presenter.login
        etPassword.text = presenter.password
        ok.setOnClickListener {
            presenter.login = etLogin.text.toString()
            presenter.password = etPassword.text.toString()
            Toast.makeText(
                applicationContext,
                "credentials " + presenter.login + " " + presenter.password + " saved",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
