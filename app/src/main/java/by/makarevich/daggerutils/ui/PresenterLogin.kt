package by.makarevich.daggerutils.ui

import by.makarevich.daggerutils.PreferencesDU
import by.makarevich.daggerutils.interfaces.IAttachablePresenter
import by.makarevich.daggerutils.interfaces.IPresenterLogin


class PresenterLogin(private val prefs: PreferencesDU) : IAttachablePresenter<IPresenterLogin>() {

        var login: String? = null
        set(value) {
            field = value
            prefs.login = field
        }
        get() = prefs.login

    var password: String? = null
        set(value) {
            field = value
            prefs.password = value
        }
        get() = prefs.password

    fun checkCredantials(login: String, password: String) {
        if (login.equals(prefs.login) && password.equals(prefs.password)) callback?.login() else callback?.showDialog("Wrong credentials")
    }
}