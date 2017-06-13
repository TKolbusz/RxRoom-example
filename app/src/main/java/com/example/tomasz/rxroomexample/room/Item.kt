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
        @ColumnInfo(name = "name") var name: String? = null,
        @ColumnInfo(name = "place") var place: String? = null,
        @ColumnInfo(name = "quantity") var quantity: String? = null,
        @ColumnInfo(name = "description") var description: String = "",
        @ColumnInfo(name = "tags") var tags: String = "",
        @ColumnInfo(name = "date_added_ms") var dateMS: Long = Calendar.getInstance().timeInMillis,
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id") var id: Long = 0
)
