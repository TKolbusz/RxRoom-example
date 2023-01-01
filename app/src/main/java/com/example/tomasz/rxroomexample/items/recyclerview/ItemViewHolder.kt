package com.example.tomasz.rxroomexample.items.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tomasz.R
import com.example.tomasz.rxroomexample.room.Item
import com.example.tomasz.rxroomexample.utils.Utils
import java.util.*

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
{
    private val name: TextView
    private val place: TextView
    private val description: TextView
    private val date: TextView
    init {
        name = view.findViewById(R.id.item_name_textView)
        place =  view.findViewById(R.id.item_place_textView)
        description = view.findViewById(R.id.item_description_textView)
        date = view.findViewById(R.id.item_date_textView)
    }
    fun bind(item: Item)
    {

        name.text = item.name
        place.text = item.place
        description.text = item.description
        date.text = Utils.Companion.dateFormatter.format(Date(item.dateMS))
    }
}
