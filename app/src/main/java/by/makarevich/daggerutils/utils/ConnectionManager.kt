package by.makarevich.daggerutils.utils

import android.content.Context
import android.net.ConnectivityManager

class ConnectionManager(val context: Context) {

    fun check(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}