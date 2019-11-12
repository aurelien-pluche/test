package com.kreactive.enceintekotlin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.utils.*
import kotlinx.android.synthetic.main.activity_info_detail.*

class InfoDetailActivity : AppCompatActivity() {

    private val id: Int by lazy { intent!!.extras!!.getInt(EXTRA_ID) }
    private val name: String by lazy { intent!!.extras!!.getString(EXTRA_NAME) }
    private val content: String by lazy { intent!!.extras!!.getString(EXTRA_CONTENT) }
    private val content2: String by lazy { intent!!.extras!!.getString(EXTRA_CONTENT_2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_detail)

        (this as AppCompatActivity).setSupportActionBar(toolbar)
        val actionBar = (this as AppCompatActivity).supportActionBar
        actionBar?.let {
            it.title = name
            it.setDisplayHomeAsUpEnabled(true)
        }

        info_detail_img.setImageResource(getPictureFromPosition(id))

        info_detail_content.text = content
        info_detail_content2.text = content2
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}