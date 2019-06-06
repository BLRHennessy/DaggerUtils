package by.makarevich.daggerutils.ui

import by.makarevich.daggerutils.utils.PreferencesDU
import by.makarevich.daggerutils.interfaces.IAttachablePresenter
import by.makarevich.daggerutils.interfaces.IPresenterLogin


class PresenterLogin(private val prefs: PreferencesDU) : IAttachablePresenter<IPresenterLogin>() {

    fun checkCredantials(login: String, password: String) {
        if (login.equals(prefs.login) && password.equals(prefs.password)) callback?.login() else callback?.showDialog("Wrong credentials")
    }
}