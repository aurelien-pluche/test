package com.kreactive.enceintekotlin.ui.view

import com.kreactive.domain.info.info.Info

interface InfoView : BaseView {

    fun updateData(content: List<Info>)

    fun showLoader()

    fun hideLoader()

}