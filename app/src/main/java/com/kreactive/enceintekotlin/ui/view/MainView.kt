package com.kreactive.enceintekotlin.ui.view

import android.graphics.drawable.Drawable
import com.kreactive.domain.info.info.Info

interface MainView : BaseView {

    fun showPictures(pictureList: ArrayList<Drawable?>)

}