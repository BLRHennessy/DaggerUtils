package by.makarevich.daggerutils.ui

import by.makarevich.daggerutils.PreferencesDU
import by.makarevich.daggerutils.interfaces.IAttachablePresenter
import by.makarevich.daggerutils.interfaces.IPresenter
import by.makarevich.daggerutils.interfaces.IPresenterRegistration


class PresenterRegistration(private val prefs: PreferencesDU) : IAttachablePresenter<IPresenterRegistration>() {

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

    fun saveCredantials(login: String, password: String) {
        this.login = login
        this.password = password
        callback?.register()
    }
}