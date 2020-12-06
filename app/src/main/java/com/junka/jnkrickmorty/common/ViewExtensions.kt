package com.junka.jnkrickmorty.common

import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
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
