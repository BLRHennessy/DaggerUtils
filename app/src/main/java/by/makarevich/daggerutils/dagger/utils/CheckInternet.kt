package by.makarevich.daggerutils.dagger.utils

import android.content.Context
import android.net.ConnectivityManager

class CheckInternet(val context: Context) {

    fun check(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}