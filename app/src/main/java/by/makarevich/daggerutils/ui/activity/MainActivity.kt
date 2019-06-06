package by.makarevich.daggerutils.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import by.makarevich.daggerutils.R
import by.makarevich.daggerutils.dagger.activity.DaggerActivityComponent
import by.makarevich.daggerutils.dagger.activity.DialogModule
import by.makarevich.daggerutils.dagger.activity.MainActivityModule
import by.makarevich.daggerutils.interfaces.IPresenter
import by.makarevich.daggerutils.ui.fragment.AbstractFragment

class MainActivity : BaseActivity(), IPresenter {


    override fun onCreate(savedInstanceState: Bundle?) {

        val activityComponent =
            DaggerActivityComponent
                .builder()
                .appComponent(appComponent)
                .dialogModule(DialogModule())
                .build()
        val authActivityComponent = activityComponent.plusMainActivitySubComponent(MainActivityModule())
        authActivityComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun showSomeFragment(fragment: AbstractFragment) {
        showFragment(fragment, R.id.fragment_container, 0, 0)
    }

    override fun showDialog(text: String) {

    }

    companion object {
        fun startActivity(ctx: Context) {
            val intent = Intent()
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            intent.setClass(ctx, MainActivity::class.java)
            ctx.startActivity(intent)
        }
    }
}
