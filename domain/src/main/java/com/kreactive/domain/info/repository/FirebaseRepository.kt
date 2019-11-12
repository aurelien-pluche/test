package com.kreactive.domain.info.repository

import com.kreactive.domain.info.food.Food
import com.kreactive.domain.info.info.Info
import io.reactivex.Single

interface FirebaseRepository {

    fun getInfo(): Single<List<Info>>

    fun getFood(title: String): Single<List<Food>>

}