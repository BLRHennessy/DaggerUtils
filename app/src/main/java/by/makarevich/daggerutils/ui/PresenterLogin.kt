package by.makarevich.daggerutils.ui

import by.makarevich.daggerutils.Prefs
import by.makarevich.daggerutils.interfaces.IAttachablePresenter
import by.makarevich.daggerutils.interfaces.IPresenter


class PresenterLogin(private val prefs: Prefs) : IAttachablePresenter<IPresenter>() {

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
}