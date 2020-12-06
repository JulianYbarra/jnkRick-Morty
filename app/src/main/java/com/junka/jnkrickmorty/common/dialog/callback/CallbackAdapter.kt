package com.junka.jnkrickmorty.common.dialog.callback

class CallbackAdapter<ReturnType> : Callback<ReturnType> {
    override fun onResolve(resolved: ReturnType) {}
    override fun onReject(error: Throwable?) {}
    override fun onFinish() {}
}