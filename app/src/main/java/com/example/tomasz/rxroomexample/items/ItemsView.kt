package com.example.tomasz.rxroomexample.items

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import butterknife.bindView
import com.example.tomasz.rxroomexample.R
import com.example.tomasz.rxroomexample.items.recyclerview.ItemsAdapter
import com.example.tomasz.rxroomexample.room.Item
import javax.inject.Inject


@SuppressLint("ViewConstructor")
class ItemsView @Inject constructor(activity: ItemsActivity) : RelativeLayout(activity)
{
    private val recyclerView: RecyclerView by bindView(R.id.items_recyclerView)
    private var recyclerViewAdapter: ItemsAdapter

    init
    {
        View.inflate(activity, R.layout.activity_items, this)
        recyclerViewAdapter = ItemsAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
        }
    }

    private fun showMessage(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    fun getToolbar() = findViewById(R.id.items_toolbar) as Toolbar

    fun showData(itemList: List<Item>) = recyclerViewAdapter.setItemsList(itemList)

    fun showLoadingDataError(message: String) = showMessage(message)

    fun showInsertingDataError(message: String) = showMessage(message)
}