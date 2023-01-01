package com.example.tomasz.rxroomexample.utils

import com.example.tomasz.rxroomexample.room.Item
import java.text.SimpleDateFormat
import java.util.*

class Utils
{
    companion object
    {
        fun randomItem(): Item {
            return Item(
                null,
                names[Random().nextInt(names.size)],
                places[Random().nextInt(places.size)],
                "1",
                descriptions[Random().nextInt(descriptions.size)],
                ""
            )
        }

        val dateFormatter: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val places =arrayOf(
            "Table",
            "Desk",
            "Chair",
            "Bed"
        )
        val descriptions = arrayOf(
            "lorem ipsum",
            "dolor sit amet",
            "sed do elusmod tempor",
            "At vero eos et accusamus"
        )
        val names = arrayOf(
            "Pencil",
            "Screen",
            "Cable",
            "Keyboard"
        )
    }
}
