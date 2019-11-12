package com.kreactive.enceintekotlin.utils

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

internal fun picasso(context: Context?, url: String?, imageView: ImageView) {
    if (context != null && !url.isNullOrEmpty()) {
        Picasso.Builder(context)
            .build().load(url).into(imageView, object : Callback {
                override fun onSuccess() {
                }

                override fun onError(e: Exception) {
                    // image download error
                }
            }
            )
    }
}