package com.example.tomasz.rxroomexample.items

import android.annotation.SuppressLint
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tomasz.R
import com.example.tomasz.rxroomexample.items.recyclerview.ItemsAdapter
import com.example.tomasz.rxroomexample.room.Item
import com.google.android.material.floatingactionbutton.FloatingActionButton
import javax.inject.Inject


@SuppressLint("ViewConstructor")
class ItemsView @Inject constructor(activity: ItemsActivity) : RelativeLayout(activity)
{
    private val recyclerView: RecyclerView
    private var recyclerViewAdapter: ItemsAdapter
    var onDeleteItemCallback:((id:Long)->Unit)?=null

    init
    {
        View.inflate(activity, R.layout.activity_items, this)
        recyclerViewAdapter = ItemsAdapter()
        recyclerView = findViewById<RecyclerView>(R.id.items_recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
        }

        val simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
            ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper.DOWN or ItemTouchHelper.UP
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                //Remove swiped item from list and notify the RecyclerView
                val itemId = recyclerViewAdapter.getItemId(viewHolder.adapterPosition)
                onDeleteItemCallback?.invoke(itemId)
            }
        }

        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private fun showMessage(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    fun getToolbar() = findViewById(R.id.items_toolbar) as Toolbar

    fun getFAB() = findViewById(R.id.items_fab) as FloatingActionButton

    fun showData(itemList: List<Item>) = recyclerViewAdapter.setItemsList(itemList)

    fun showItemsAt(itemList: List<Item>) = showMessage("items at " + itemList[0].place + " are: " + itemList.toString())

    fun showLoadingDataError(message: String) = showMessage(message)

    fun showError(message: String) = showMessage(message)

    fun showItemAddedMessage() = Toast.makeText(context, "Item added", Toast.LENGTH_SHORT).show()

    fun showItemDeletedMessage()  =  Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT).show()

}