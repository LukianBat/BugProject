package com.education.bugproject

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(model: ItemModel) {
        val textView: TextView = itemView.findViewById(R.id.item_text_view)
        val item: LinearLayout = itemView.findViewById(R.id.item_bottom_sheet)
        val scrollView = itemView.findViewById(R.id.scroll_view) as NestedScrollView
        scrollView.rootView.setOnTouchListener { view, motionEvent ->
            Log.i("TAG", motionEvent.toString())
            false
        }
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