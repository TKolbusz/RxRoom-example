package com.example.tomasz.rxroomexample.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * required fields are marked as ? so that when you forget to initialize them, Room database will throw an exception on during insertion
 * each field has to have default value in order for class to have default constructor
 */
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
