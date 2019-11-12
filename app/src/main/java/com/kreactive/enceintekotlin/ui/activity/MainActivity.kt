package com.kreactive.enceintekotlin.ui.activity

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.kreactive.domain.info.interactor.GetInfo
import com.kreactive.enceintekotlin.BaseApplication
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.presenter.MainPresenter
import com.kreactive.enceintekotlin.ui.view.MainView
import com.kreactive.enceintekotlin.utils.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView, View.OnClickListener {

    private val mainPresenter: MainPresenter by lazy {
        MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_info.setOnClickListener(this)
        main_alimentation.setOnClickListener(this)

        title_main.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        mainPresenter.initialize(this, GetInfo((application as BaseApplication).firebaseRepository))
    }

    override fun showPictures(pictureList: ArrayList<Drawable?>) {
        for (i in 0 until pictureList.size) {
            val picture = pictureList[i]
            if (picture != null) {
                val view = ImageView(this)
                view.setImageDrawable(picture)
                view.scaleType = ImageView.ScaleType.CENTER_CROP
                view_flipper.addView(view)
                view_flipper.setFlipInterval(10000)
                view_flipper.isAutoStart = true
                view_flipper.setInAnimation(this, R.anim.fade_in)
                view_flipper.setOutAnimation(this, R.anim.fade_out)
            }
        }
    }

    override fun showError(error: String) {
        //nothing
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.main_info -> {
                openInfoActivity(this)
            }
            R.id.main_alimentation -> {
                openFoodActivity(this)
            }
        }
    }
}