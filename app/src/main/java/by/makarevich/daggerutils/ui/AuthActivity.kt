package by.makarevich.daggerutils.ui

import android.os.Bundle
import android.widget.TextView
import by.makarevich.daggerutils.PreferencesDU
import by.makarevich.daggerutils.R
import by.makarevich.daggerutils.dagger.activity.AuthActivityModule
import by.makarevich.daggerutils.dagger.activity.DaggerAuthActivityConponent
import by.makarevich.daggerutils.interfaces.IPresenter
import by.makarevich.daggerutils.ui.activity.BaseActivity
import javax.inject.Inject

class AuthActivity : BaseActivity(), IPresenter {
    @Inject
    lateinit var presenter: PresenterLogin
    @Inject
    lateinit var prefs: PreferencesDU

    private val etLogin: TextView by lazy { findViewById<TextView>(R.id.login) }
    private val etPassword: TextView by lazy { findViewById<TextView>(R.id.password) }
    private val ok: TextView by lazy { findViewById<TextView>(R.id.ok) }

    override fun getText(): String = presenter.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        val presenterComponent = DaggerAuthActivityConponent
            .builder()
            .appComponent(appComponent)
            .authActivityModule(AuthActivityModule())
            .build()
        presenterComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
