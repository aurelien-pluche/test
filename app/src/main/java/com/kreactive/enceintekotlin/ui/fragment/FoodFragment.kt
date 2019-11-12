package com.kreactive.enceintekotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kreactive.domain.info.food.Food
import com.kreactive.domain.info.interactor.GetFood
import com.kreactive.enceintekotlin.BaseApplication
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.presenter.FoodPresenter
import com.kreactive.enceintekotlin.ui.adapter.FoodAdapter
import com.kreactive.enceintekotlin.ui.view.FoodView
import com.kreactive.enceintekotlin.utils.EXTRA_NAME
import com.kreactive.enceintekotlin.utils.getPath
import kotlinx.android.synthetic.main.fragment_food.*

class FoodFragment : Fragment(), FoodView {

    private val title: String by lazy { arguments!!.getString(EXTRA_NAME) }

    private val foodPresenter: FoodPresenter by lazy {
        FoodPresenter()
    }

    private lateinit var recycler: RecyclerView
    private val adapter: FoodAdapter by lazy { FoodAdapter(requireContext()) }

    companion object {
        const val TAG: String = "FoodFragment"

        fun newInstance(title: String): FoodFragment {
            val b = Bundle()
            b.putString(EXTRA_NAME, title)
            val fragment = FoodFragment()
            fragment.arguments = b
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recycler = view.findViewById(R.id.food_recylcer_view)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        foodPresenter.initialize(
            this,
            GetFood(
                (activity!!.applicationContext as BaseApplication).firebaseRepository,
                getPath(requireContext(), title)
            )
        )
    }

    override fun updateData(content: List<Food>) {
        adapter.updateData(content)
    }

    override fun showLoader() {
        if (food_progress != null) {
            food_progress.visibility = View.VISIBLE
        }
    }

    override fun hideLoader() {
        if (food_progress != null) {
            food_progress.visibility = View.GONE
        }
    }

    override fun showError(error: String) {
    }

}