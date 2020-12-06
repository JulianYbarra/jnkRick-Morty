package com.junka.jnkrickmorty.common

import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate
import kotlin.math.max

fun FragmentActivity.getScreenHeight(): Int {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    val x = metrics.widthPixels
    val y = metrics.heightPixels
    return max(x, y)
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun View.showOrHide(visibility : Boolean){
    if(visibility) show() else hide()
}

fun ImageView.load(url : String){
    Glide.with(context).load(url).into(this)
}

@ExperimentalCoroutinesApi
val RecyclerView.lastVisibleEvents: Flow<Int>
    get() = callbackFlow<Int> {

        val lm = when(layoutManager){
            is GridLayoutManager -> layoutManager as GridLayoutManager
            else -> layoutManager as LinearLayoutManager
        }

        val listener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                offer(lm.findLastVisibleItemPosition())
            }
        }
        addOnScrollListener(listener)
        awaitClose { removeOnScrollListener(listener) }
    }.conflate()
