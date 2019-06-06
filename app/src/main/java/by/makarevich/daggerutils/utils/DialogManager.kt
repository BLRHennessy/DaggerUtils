package by.makarevich.daggerutils.utils

import android.app.AlertDialog
import android.content.Context

class DialogManager {
    fun showDialog(context: Context, text: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Error")
        builder.setMessage(text)
        builder.show()
    }
}