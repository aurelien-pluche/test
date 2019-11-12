package com.kreactive.enceintekotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kreactive.domain.info.info.Info
import com.kreactive.enceintekotlin.R
import com.kreactive.enceintekotlin.utils.openInfoDetailActivity
import com.kreactive.enceintekotlin.utils.picasso

class InfoAdapter(private val context: Context) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    private var data: List<Info>? = null
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val itemView = inflater.inflate(R.layout.item_info, parent, false)
        return InfoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (data != null) {
            return data!!.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        if (data != null && data!!.isNotEmpty()) {
            holder.bind(data!![position], position)
        }
    }

    fun updateData(infolList: List<Info>?) {
        if (infolList != null) {
            data = infolList
        }
        notifyDataSetChanged()
    }

    inner class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val img: ImageView = itemView.findViewById(R.id.item_info_picture)
        private val container: View = itemView.findViewById(R.id.item_info)
        private val title: TextView = itemView.findViewById(R.id.item_info_title)

        fun bind(info: Info, position: Int) {
            picasso(context, info.img, img)
            container.setOnClickListener {
                openInfoDetailActivity(
                    context,
                    position,
                    info.name,
                    info.content,
                    info.content_2
                )
            }
            title.text = info.name
        }
    }

}