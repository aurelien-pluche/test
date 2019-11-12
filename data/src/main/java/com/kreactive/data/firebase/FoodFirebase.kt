package com.kreactive.data.firebase

import androidx.annotation.Keep

@Keep
class FoodFirebase constructor(
    val name: String,
    val name_en: String,
    val i: Int,
    val img: Int,
    val r: Int
) {
    constructor() : this("", "", 0, 0, 0)
}