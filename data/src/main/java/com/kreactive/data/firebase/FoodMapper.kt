package com.kreactive.data.firebase

import com.kreactive.domain.info.food.Food
import java.util.*
import kotlin.collections.ArrayList

internal fun foodMapper(food: FoodFirebase): Food {

    val name: String
    val language = Locale.getDefault().language
    name = if (language == "fr") {
        food.name
    } else {
        food.name_en
    }

    return Food(name, food.img, food.i, food.r)
}

internal fun foodListMapper(foods: MutableList<FoodFirebase>): List<Food> {
    val foodList = ArrayList<Food>(foods.size)
    foods.forEach {
        foodList.add(foodMapper(it))
    }
    return foodList
}