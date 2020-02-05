package com.education.bugproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior


class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(model: ItemModel) {
        val bottomSheet: LinearLayout = itemView.rootView.rootView.rootView.findViewById(R.id.base_bottom_sheet)
        val scrollView: ScrollView = itemView.findViewById(R.id.scroll_view)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        val textView: TextView = itemView.findViewById(R.id.item_text_view)
        textView.text =""
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        for (i in 1..50) {
            textView.append(model.number.toString() + "\n")
        }
        scrollView.viewTreeObserver
            .addOnScrollChangedListener {
                if (scrollView.getChildAt(0).bottom <= scrollView.height + scrollView.scrollY) {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                }
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