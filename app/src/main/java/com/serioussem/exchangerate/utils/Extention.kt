package com.serioussem.exchangerate.utils

import android.animation.AnimatorSet
import android.view.View
import android.view.animation.AnimationSet
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun String.getFiveFirstChars(): String =
    if (this.length > 4) this.substring(0, 5) else this

fun View.showSnackBar(message: String, length: Int = Snackbar.LENGTH_SHORT) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}

fun View.showView(): View {
    visibility = View.VISIBLE
    return this
}

fun View.hideView(): View {
    visibility = View.GONE
    return this
}

fun <T> Fragment.collectFlow(flow: Flow<T>, onCollect: suspend (T) -> Unit) =
    viewLifecycleOwner.lifecycleScope.launch {
        flow.flowWithLifecycle(
            viewLifecycleOwner.lifecycle,
            Lifecycle.State.STARTED
        ).collectLatest(onCollect)
    }

fun List<AnimatorSet>.playAllSets(coroutineScope: CoroutineScope, end: () -> Unit) {
    coroutineScope.launch(Dispatchers.Main) {
        for (animSet in this@playAllSets) {
            animSet.start()
            delay(animSet.duration)
        }
        end.invoke()
    }
}