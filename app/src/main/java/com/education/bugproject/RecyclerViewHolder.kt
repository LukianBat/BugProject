package com.education.bugproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(model: ItemModel) {
        val textView: TextView = itemView.findViewById(R.id.item_text_view)
        textView.text = ""
        for (i in 1..50) {
            textView.append(model.number.toString() + "\n")
        }
    }

    companion object {
        fun create(context: Context, parent: ViewGroup): RecyclerViewHolder {
            return RecyclerViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.recycler_item,
                    parent,
                    false
                )
            )
        }
    }
}