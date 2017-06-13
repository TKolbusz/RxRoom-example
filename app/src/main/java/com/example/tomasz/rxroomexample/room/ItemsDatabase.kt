package com.example.tomasz.rxroomexample.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.tomasz.rxroomexample.ApplicationScope

@ApplicationScope
@Database(entities = arrayOf(Item::class), version = 1)
abstract class ItemsDatabase : RoomDatabase()
{
    abstract fun itemDao(): ItemDao
}
