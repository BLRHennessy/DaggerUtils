package by.makarevich.daggerutils.ui.activity

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import by.makarevich.daggerutils.dagger.activity.ActivityComponent
import by.makarevich.daggerutils.dagger.activity.DaggerActivityComponent
import by.makarevich.daggerutils.dagger.application.AppComponent
import by.makarevich.daggerutils.ui.fragment.AbstractFragment

open class BaseActivity : AppCompatActivity() {

    val appComponent: AppComponent by lazy { (application as by.makarevich.daggerutils.App).getAppComponent() }
    var activityComponent: ActivityComponent? = null

    override fun onStart() {
        activityComponent = DaggerActivityComponent
            .builder()
            .appComponent(appComponent)
            .build()
        super.onStart()
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

    fun showFragment(fragment: AbstractFragment, container: Int, `in`: Int, out: Int) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.setCustomAnimations(`in`, out)
        transaction.replace(container, fragment)
        transaction.commitAllowingStateLoss()
        manager.popBackStack()
    }
}