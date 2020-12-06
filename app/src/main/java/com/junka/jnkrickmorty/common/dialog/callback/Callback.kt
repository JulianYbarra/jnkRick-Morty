package com.junka.jnkrickmorty.common.dialog.callback

import com.junka.jnkrickmorty.common.dialog.base.BaseDialogFragment

interface Callback<ReturnType> : BaseDialogFragment.BaseDialogFragmentCallback {
    fun onResolve(resolved: ReturnType)
    fun onReject(error: Throwable?)
    fun onFinish()
}