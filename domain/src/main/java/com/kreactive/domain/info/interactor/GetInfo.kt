package com.kreactive.domain.info.interactor

import com.kreactive.domain.info.info.Info
import com.kreactive.domain.info.repository.FirebaseRepository
import io.reactivex.Single

class GetInfo(private val firebaseRepository: FirebaseRepository) {

    fun buildUseCaseSingle(): Single<List<Info>> = firebaseRepository.getInfo()
}