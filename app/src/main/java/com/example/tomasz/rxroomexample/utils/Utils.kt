package com.example.tomasz.rxroomexample.utils

import com.example.tomasz.rxroomexample.room.Item
import java.text.SimpleDateFormat
import java.util.*

class Utils
{
    companion object
    {
        val dateFormatter: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val items = arrayOf(
                Item("Pencil", "Table", "2", "sharpest pencils in the world"),
                Item("Screen", "Desk", "1", "broken screen"),
                Item("Chair", "Bedroom", "3", "old chairs"),
                Item("Keyboard", "Desk", "1", "weird keyboard")
        )
    }
}
