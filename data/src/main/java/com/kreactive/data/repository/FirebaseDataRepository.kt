package com.kreactive.data.repository

import com.kreactive.data.firebase.FirebaseService
import com.kreactive.domain.info.food.Food
import com.kreactive.domain.info.info.Info
import com.kreactive.domain.info.repository.FirebaseRepository
import io.reactivex.Single

class FirebaseDataRepository : FirebaseRepository {

    private val firebaseService = FirebaseService()

    override fun getInfo(): Single<List<Info>> {
        return firebaseService.getInfo()
    }

    override fun getFood(title: String): Single<List<Food>> {
        return firebaseService.getFood(title)
    }
}