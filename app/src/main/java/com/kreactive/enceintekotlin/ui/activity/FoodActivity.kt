package com.kreactive.enceintekotlin.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.ui.fragment.FoodFragment
import com.kreactive.enceintekotlin.utils.replaceFragment
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_info.info_back

const val STATE_CURRENT_POSITION = "STATE_CURRENT_POSITION"

class FoodActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var position = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        savedInstanceState?.let {
            position = it.getString(STATE_CURRENT_POSITION)
        }

        if (position == "") {
            position = getString(R.string.nav_fruit_vegetable_title)
        }

        displayFragment(position)

        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        info_back.setOnClickListener { finish() }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        displayFragment(menuItem.title.toString())
        position = menuItem.title.toString()
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(STATE_CURRENT_POSITION, position)

        super.onSaveInstanceState(outState)
    }

    private fun displayFragment(title: String) {
        replaceFragment(supportFragmentManager, R.id.fragmentContainer, FoodFragment.TAG, {
            FoodFragment.newInstance(title)
        })
    }

}