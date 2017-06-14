package com.example.tomasz.rxroomexample.items.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.bindView
import com.example.tomasz.rxroomexample.R
import com.example.tomasz.rxroomexample.room.Item
import com.example.tomasz.rxroomexample.utils.Utils
import java.util.*

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
{
    private val name: TextView by bindView(R.id.item_name_textView)
    private val place: TextView by bindView(R.id.item_place_textView)
    private val description: TextView by bindView(R.id.item_description_textView)
    private val date: TextView by bindView(R.id.item_date_textView)
    fun bind(item: Item)
    {
        name.text = item.name
        place.text = item.place
        description.text = item.description
        date.text = Utils.Companion.dateFormatter.format(Date(item.dateMS))
    }
}
