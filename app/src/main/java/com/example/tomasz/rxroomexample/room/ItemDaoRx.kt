package com.example.tomasz.rxroomexample.room

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable


@Dao
interface ItemDaoRx
{
    @Query("SELECT * FROM item")
    fun getAllItems(): Flowable<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: Item) : Completable

    @Query("DELETE FROM item WHERE id = :id")
    fun deleteItem(id: Long) : Completable
}
