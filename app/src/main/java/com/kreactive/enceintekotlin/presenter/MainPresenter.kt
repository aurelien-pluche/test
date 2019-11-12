package com.kreactive.enceintekotlin.presenter

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.kreactive.domain.info.interactor.GetInfo
import com.kreactive.enceintekotlin.BasePresenter
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.ui.view.MainView

class MainPresenter(private val context: Context) : BasePresenter<String>() {

    override fun showInView(content: String) {
    }

    fun initialize(view: MainView, getInfo: GetInfo) {
        this.view = view
        getPictures()
    }

    private fun getPictures() {
        val pictureList = ArrayList<Drawable?>()
        pictureList.add(
            ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.background, null
            )
        )
        pictureList.add(
            ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.background_2, null
            )
        )
        pictureList.add(
            ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.background_3, null
            )
        )
        pictureList.add(
            ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.background_4, null
            )
        )
        pictureList.add(
            ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.background_5, null
            )
        )
        pictureList.add(
            ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.background_6, null
            )
        )
        pictureList.add(
            ResourcesCompat.getDrawable(
                context.resources,
                R.drawable.background_7, null
            )
        )
        (view as MainView).showPictures(pictureList)
    }

}