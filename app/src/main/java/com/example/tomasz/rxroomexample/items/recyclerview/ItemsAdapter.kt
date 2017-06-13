package com.example.tomasz.rxroomexample.items.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tomasz.rxroomexample.R
import com.example.tomasz.rxroomexample.room.Item
import io.reactivex.subjects.PublishSubject

class ItemsAdapter : RecyclerView.Adapter<ItemViewHolder>()
{
    private val onClickSubject = PublishSubject.create<Item>()
    private val onLongClickSubject = PublishSubject.create<Unit>()
    private var itemList: List<Item> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder
    {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener { onClickSubject.onNext(itemList[position]) }
        holder.itemView.setOnLongClickListener {
            onLongClickSubject.onNext(Unit)
            true
        }
    }


    override fun getItemCount(): Int
    {
        return itemList.size
    }

    fun setItemsList(itemList: List<Item>)
    {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}
