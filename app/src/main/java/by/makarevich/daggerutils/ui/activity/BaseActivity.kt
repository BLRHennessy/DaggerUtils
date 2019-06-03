package by.makarevich.daggerutils.ui.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import by.makarevich.daggerutils.dagger.application.AppComponent

open class BaseActivity : AppCompatActivity() {
    val appComponent: AppComponent by lazy { (application as by.makarevich.daggerutils.App).getAppComponent() }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    protected fun getContext(): Context = this

    fun hideKeyboard() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val window = window
        if (window != null) {
            val currentFocus = window.currentFocus
            if (currentFocus != null) {
                val windowToken = currentFocus.windowToken
                if (windowToken != null) {
                    imm.hideSoftInputFromWindow(windowToken, 0)
                }
            }
        }
    }
}