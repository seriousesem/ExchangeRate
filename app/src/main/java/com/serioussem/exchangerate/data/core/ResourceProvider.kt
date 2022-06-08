package com.serioussem.exchangerate.data.core

import android.content.Context
import androidx.annotation.StringRes

class ResourceProvider(private  val context: Context) {

    fun string(@StringRes id: Int): String = context.getString(id)

    fun string(@StringRes id: Int, vararg args: Any): String = context.getString(id, args)
}