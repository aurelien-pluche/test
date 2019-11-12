package com.kreactive.enceintekotlin

import com.kreactive.enceintekotlin.ui.view.BaseView
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

abstract class BasePresenter<C> {

    var disposable: Disposable? = null
    var view: BaseView? = null

    fun onStop() {
        disposable?.dispose()
        disposable = null
    }

    fun onDestroy() {
        onStop()
        view = null
    }

    protected abstract fun showInView(content: C)

    protected fun defaultEntityObserver() = object : SingleObserver<C> {

        override fun onError(e: Throwable) {
            view?.showError(e.message.toString())
        }

        override fun onSubscribe(d: Disposable) {
            disposable = d
        }

        override fun onSuccess(@io.reactivex.annotations.NonNull entityList: C) {
            view?.let {
                showInView(entityList)
            }
        }

    }
}