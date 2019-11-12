package com.kreactive.enceintekotlin.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.kreactive.domain.info.food.Food
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.ui.activity.FoodActivity
import com.kreactive.enceintekotlin.ui.activity.FoodDetailActivity
import com.kreactive.enceintekotlin.ui.activity.InfoActivity
import com.kreactive.enceintekotlin.ui.activity.InfoDetailActivity

fun openInfoActivity(activity: Activity?) {
    if (activity != null) {
        val intent = Intent(activity.applicationContext, InfoActivity::class.java)
        activity.startActivity(intent)
    }
}

fun openInfoDetailActivity(context: Context?, id: Int, name: String, content: String, content2: String) {
    if (context != null) {
        val intent = Intent(context.applicationContext, InfoDetailActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        intent.putExtra(EXTRA_NAME, name)
        intent.putExtra(EXTRA_CONTENT, content)
        intent.putExtra(EXTRA_CONTENT_2, content2)
        context.startActivity(intent)
    }
}

fun openFoodActivity(activity: Activity?) {
    if (activity != null) {
        val intent = Intent(activity.applicationContext, FoodActivity::class.java)
        activity.startActivity(intent)
    }
}

fun openFoodDetailActivity(context: Context?, food: Food) {
    if (context != null) {
        val intent = Intent(context.applicationContext, FoodDetailActivity::class.java)
        intent.putExtra(EXTRA_NAME, food.name)
        intent.putExtra(EXTRA_INFO, food.info)
        intent.putExtra(EXTRA_RISK, food.risque)
        intent.putExtra(EXTRA_AVIS, food.img)
        context.startActivity(intent)
    }
}

fun shareFood(activity: Activity?, title: String, info: String, risk: String){
    if (activity != null) {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, activity.getString(R.string.share_food, title, info, risk))
        activity.startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}