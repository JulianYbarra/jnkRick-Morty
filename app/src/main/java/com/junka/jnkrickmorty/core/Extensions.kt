package com.junka.jnkrickmorty.core

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun ImageView.load(url : String){
    Glide.with(this.context).load(url).into(this)
}

fun <T> LifecycleOwner.observer(liveData: LiveData<T>, observer: (T) -> Unit){
    liveData.observe(this, Observer (observer))
}