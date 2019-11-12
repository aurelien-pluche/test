package com.kreactive.enceintekotlin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.utils.*
import kotlinx.android.synthetic.main.activity_food_detail.*

class FoodDetailActivity : AppCompatActivity() {

    private val name: String by lazy { intent!!.extras!!.getString(EXTRA_NAME) }
    private val info: Int by lazy { intent!!.extras!!.getInt(EXTRA_INFO, 0) }
    private val risk: Int by lazy { intent!!.extras!!.getInt(EXTRA_RISK) }
    private val avis: Int by lazy { intent!!.extras!!.getInt(EXTRA_AVIS, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        food_detail_back.setOnClickListener { finish() }
        food_detail_share.setOnClickListener { shareFood(this, name, getInfoFood(this, info), getRiskFood(this, risk)) }

        food_detail_title.text = name
        food_detail_avis.text = getAvis(this, avis)
        food_detail_information.text = getInfoFood(this, info)
        food_detail_risk.text = getRiskFood(this, risk)
    }
}