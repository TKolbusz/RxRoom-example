package com.example.tomasz.rxroomexample.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Item::class), version = 1)
abstract class ItemsDatabase : RoomDatabase()
{
    abstract fun itemDao(): ItemDao
}
