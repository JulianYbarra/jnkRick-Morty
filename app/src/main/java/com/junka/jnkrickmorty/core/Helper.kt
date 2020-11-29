package com.junka.jnkrickmorty.core

import android.net.Uri

object Helper {

    fun getIdsFromUrl(urls: List<String>): List<Long> {
        return urls.map { url ->
            Uri.parse(url).lastPathSegment!!.toLong()
        }
    }
}