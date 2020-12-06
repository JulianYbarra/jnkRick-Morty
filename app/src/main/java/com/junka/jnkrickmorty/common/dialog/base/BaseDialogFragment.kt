package com.junka.jnkrickmorty.common.dialog.base

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.DialogFragment


open class BaseDialogFragment<T : BaseDialogFragment.BaseDialogFragmentCallback> : DialogFragment() {

    protected var callback: T? = null

    val dialogTag: String = this.javaClass.name

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    fun setCallback(callback: T): BaseDialogFragment<*> {
        this.callback = callback
        return this
    }

    interface BaseDialogFragmentCallback
}