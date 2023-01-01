package com.example.tomasz.rxroomexample.room

import androidx.room.*
import io.reactivex.Flowable


@Dao
interface ItemDaoRx
{
    @Query("SELECT * FROM item")
    fun getAllItems(): Flowable<List<Item>>

    @Query("SELECT * FROM item WHERE place = :place")
    fun getItemsAt(place: String): Flowable<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: Item)

    @Query("DELETE FROM item WHERE id = :id")
    fun deleteItem(id: Long)
}
