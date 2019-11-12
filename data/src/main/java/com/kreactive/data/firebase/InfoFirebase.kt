package com.kreactive.data.firebase

import androidx.annotation.Keep

@Keep
class InfoFirebase constructor(
    val id: Int,
    val content: String,
    val content_en: String,
    val img: String,
    val mam: String,
    val mam_en: String,
    val name: String,
    val name_en: String
) {
    constructor() : this(0, "", "", "", "", "", "", "")
}