package com.junka.jnkrickmorty.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Origin(
    val originName: String = "",
    val originUrl: String = ""
): Parcelable


@Parcelize
data class OriginRemote(
    val name: String = "",
    val url: String = ""
): Parcelable