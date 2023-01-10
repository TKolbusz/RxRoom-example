package com.example.tomasz.rxroomexample.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface ItemDaoCoroutines {
    @Query("SELECT * FROM item")
    suspend fun getAllItems(): List<Item>

    @Query("SELECT * FROM item WHERE place = :place")
    suspend fun getItemsAt(place: String): List<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun deleteItem(id: Long)
}