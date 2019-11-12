package com.kreactive.enceintekotlin.presenter

import com.kreactive.domain.info.info.Info
import com.kreactive.domain.info.interactor.GetInfo
import com.kreactive.enceintekotlin.BasePresenter
import com.kreactive.enceintekotlin.ui.view.InfoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InfoPresenter : BasePresenter<List<Info>>() {

    override fun showInView(content: List<Info>) {
        (view as InfoView).updateData(content)
    }

    fun initialize(view: InfoView, getInfo: GetInfo) {
        this.view = view
        (this.view as InfoView).showLoader()
        getInfo.buildUseCaseSingle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(defaultEntityObserver())
    }

}