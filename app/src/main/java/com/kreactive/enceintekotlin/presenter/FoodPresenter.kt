package com.kreactive.enceintekotlin.presenter

import com.kreactive.domain.info.food.Food
import com.kreactive.domain.info.interactor.GetFood
import com.kreactive.enceintekotlin.BasePresenter
import com.kreactive.enceintekotlin.ui.view.FoodView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FoodPresenter : BasePresenter<List<Food>>() {

    override fun showInView(content: List<Food>) {
        val sorted = content.sortedBy { it.name }
        (view as FoodView).hideLoader()
        (view as FoodView).updateData(sorted)
    }

    fun initialize(view: FoodView, getFood: GetFood) {
        this.view = view
        (this.view as FoodView).showLoader()
        getFood.buildUseCaseSingle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(defaultEntityObserver())
    }
}