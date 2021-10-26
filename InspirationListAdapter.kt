package com.razzaq.bitaqwaapp.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.razzaq.bitaqwaapp.R
import com.razzaq.bitaqwaapp.dashboard.model.InspirationModel

class InspirationListAdapter(private val listInspiration: ArrayList<InspirationModel>) :
    RecyclerView.Adapter<InspirationListAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.ivItemRow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_inspirations, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val inspiration = listInspiration[position]
        Glide.with(holder.itemView.context)
            .load(inspiration.inspirationImage)
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return listInspiration.size
    }

}