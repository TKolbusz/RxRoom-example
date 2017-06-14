package com.example.tomasz.rxroomexample.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "items")
data class Item(
        @PrimaryKey
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
