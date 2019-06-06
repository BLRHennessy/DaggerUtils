package by.makarevich.daggerutils.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import by.makarevich.daggerutils.R
import by.makarevich.daggerutils.dagger.activity.DaggerMainActivityComponent
import by.makarevich.daggerutils.interfaces.IPresenter

class MainActivity : BaseActivity(), IPresenter {

    override fun onCreate(savedInstanceState: Bundle?) {

        val mainActivityComponent =
            DaggerMainActivityComponent
                .builder()
                .appComponent(appComponent)
                .build()
        mainActivityComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
