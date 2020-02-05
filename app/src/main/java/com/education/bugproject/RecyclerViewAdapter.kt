package com.education.bugproject

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context, private val itemList: List<ItemModel>) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder.create(context, parent)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}