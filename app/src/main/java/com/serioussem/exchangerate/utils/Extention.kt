package com.serioussem.exchangerate.utils

import android.app.Activity
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

fun updateText(view: TextView, message: Any) {
    view.text = message.toString()
}

fun Activity.snackbar(message: String) {
    Snackbar.make(this, findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
}

fun showView(view: View) {
    view.visibility = View.VISIBLE
}

fun hideView(view: View) {
    view.visibility = View.GONE
}