package com.kreactive.enceintekotlin.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kreactive.domain.info.info.Info
import com.kreactive.domain.info.interactor.GetInfo
import com.kreactive.enceintekotlin.BaseApplication
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.presenter.InfoPresenter
import com.kreactive.enceintekotlin.ui.adapter.InfoAdapter
import com.kreactive.enceintekotlin.ui.view.InfoView
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity(), InfoView {

    private val infoPresenter: InfoPresenter by lazy {
        InfoPresenter()
    }

    private lateinit var recycler: RecyclerView
    private val adapter: InfoAdapter by lazy { InfoAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        recycler = findViewById(R.id.info_recylcer_view)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        info_back.setOnClickListener { finish() }

        infoPresenter.initialize(this, GetInfo((application as BaseApplication).firebaseRepository))
    }

    override fun updateData(content: List<Info>) {
        hideLoader()
        adapter.updateData(content)
    }

    override fun showError(error: String) {
        hideLoader()
    }

    override fun showLoader() {
        info_progress.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        info_progress.visibility = View.GONE
    }

}