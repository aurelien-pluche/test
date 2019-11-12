package com.kreactive.enceintekotlin.ui.view

import com.kreactive.domain.info.food.Food

interface FoodView : BaseView {

    fun updateData(content: List<Food>)

    fun showLoader()

    fun hideLoader()

}