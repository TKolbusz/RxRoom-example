package com.example.tomasz.rxroomexample.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "item")
data class Item(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")var id :Long?=null,
        @ColumnInfo(name = "name") var name: String = "",
        @ColumnInfo(name = "place") var place: String = "",
        @ColumnInfo(name = "quantity") var quantity: String = "",
        @ColumnInfo(name = "description") var description: String = "",
        @ColumnInfo(name = "tags") var tags: String = "",
        @ColumnInfo(name = "date_added_ms") var dateMS: Long = Calendar.getInstance().timeInMillis
)
{
    override fun toString(): String = name
}
