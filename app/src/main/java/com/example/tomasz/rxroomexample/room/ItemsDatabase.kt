package com.example.tomasz.rxroomexample.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Item::class), version = 1)
abstract class ItemsDatabase : RoomDatabase()
{
    abstract fun itemDaoRx(): ItemDaoRx
    abstract fun itemDaoCoroutines(): ItemDaoCoroutines
}
