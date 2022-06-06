package com.serioussem.exchangerate.utils

import android.app.Activity
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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

fun <T> Fragment.collectFlow(flow: Flow<T>, onCollect: suspend (T) -> Unit) =
    viewLifecycleOwner.lifecycleScope.launch {
        flow.flowWithLifecycle(
            viewLifecycleOwner.lifecycle,
            Lifecycle.State.STARTED
        ).collectLatest(onCollect)
    }