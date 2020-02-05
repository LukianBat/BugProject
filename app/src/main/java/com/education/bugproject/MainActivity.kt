package com.education.bugproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity : AppCompatActivity() {

    private val itemList = arrayListOf<ItemModel>().apply {
        for (i in 0..100) {
            this.add(ItemModel(i))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val snapHelper = LinearSnapHelper()
        recycler_view.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        snapHelper.attachToRecyclerView(recycler_view)
        recycler_view.adapter = RecyclerViewAdapter(this, itemList)
    }
}
