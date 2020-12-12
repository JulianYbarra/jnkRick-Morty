package com.junka.jnkrickmorty.common

import android.net.Uri
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
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

fun ImageView.downloadImage(imageSting: String, circle: Boolean = false) {
    if (imageSting.contains("https")) {
        downloadUrlImage(imageSting, circle)
    } else {
        downloadUriImage(Uri.parse(imageSting), circle)
    }
}

fun ImageView.downloadUriImage(uri: Uri, circle: Boolean = false) {
    Glide.with(context)
        .load(uri)
        .apply(if (circle) RequestOptions.circleCropTransform() else RequestOptions.noTransformation())
        .into(this)
}

fun ImageView.downloadUrlImage(imageUrl: String, circle: Boolean) {
    Glide.with(context)
        .load(imageUrl)
        .apply(if (circle) RequestOptions.circleCropTransform() else RequestOptions.noTransformation())
        .into(this)
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
