package com.cassiolucianodasilva.movielist.util

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.cassiolucianodasilva.movielist.R

object DialogFactory {
    fun getLoading(context: Context): MaterialDialog {
        return MaterialDialog.Builder(context)
            .progress(true, 0)
            .cancelable(false)
            .title(R.string.app_name)
            .content("Aguarde enquanto seus dados são carregados...")
            .build()

    }

    fun getDialogError(context: Context, message: String): MaterialDialog {
        return MaterialDialog.Builder(context)
            .cancelable(true)
            .content(message)
            .title(R.string.app_name)
            .positiveText("OK")
            .build()
    }
}