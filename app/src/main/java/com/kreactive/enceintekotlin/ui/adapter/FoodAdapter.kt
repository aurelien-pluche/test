package com.kreactive.enceintekotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.kreactive.domain.info.food.Food
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.utils.getColorByFood
import com.kreactive.enceintekotlin.utils.getLogoFood
import com.kreactive.enceintekotlin.utils.openFoodDetailActivity

class FoodAdapter(private val context: Context) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var data: List<Food>? = null
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = inflater.inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (data != null) {
            return data!!.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        if (data != null && data!!.isNotEmpty()) {
            holder.bind(data!![position])
        }
    }

    fun updateData(foodList: List<Food>?) {
        if (foodList != null) {
            data = foodList
        }
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val container: View = itemView.findViewById(R.id.item_food)
        private val title: TextView = itemView.findViewById(R.id.item_food_title)
        private val img: ImageView = itemView.findViewById(R.id.item_food_logo)

        fun bind(food: Food) {
            img.setImageResource(getLogoFood(food.img))
            title.text = food.name
            img.background = getColorByFood(context, food.img)
            container.setOnClickListener {
                openFoodDetailActivity(context, food)
            }
        }
    }

}