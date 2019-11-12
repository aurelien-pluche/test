package com.kreactive.domain.info.interactor

import com.kreactive.domain.info.food.Food
import com.kreactive.domain.info.repository.FirebaseRepository
import io.reactivex.Single

class GetFood(private val firebaseRepository: FirebaseRepository, private val title: String) {
    fun buildUseCaseSingle(): Single<List<Food>> = firebaseRepository.getFood(title)
}