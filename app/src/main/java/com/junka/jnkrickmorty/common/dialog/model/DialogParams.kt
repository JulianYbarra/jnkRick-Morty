package com.ubicuo.ubicuo.common.dialog.model

import com.junka.jnkrickmorty.common.dialog.callback.Callback

data class DialogParams(
    val title: String = "",
    val message: String = "",
    val okButton: String = "",
    val cancelButton: String = "",
    val callback: Callback<Unit>,
    val subTitle: String = ""
)