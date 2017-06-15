package com.example.tomasz.rxroomexample.room

import android.arch.persistence.room.*
import io.reactivex.Flowable

@Dao
interface ItemDao
{
    @Query("SELECT name, place, description, date_added_ms FROM items")
    fun getAllItems(): Flowable<List<Item>>

    @Query("SELECT name FROM items WHERE place = :arg0")
    fun getItemsAt(place: String): Flowable<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}
