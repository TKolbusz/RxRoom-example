package com.example.tomasz.rxroomexample

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.tomasz.rxroomexample.room.ItemDao
import com.example.tomasz.rxroomexample.room.ItemsDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseTest
{
    private lateinit var itemDao: ItemDao
    private lateinit var db: ItemsDatabase

    @Before
    fun createDb()
    {
        val context = InstrumentationRegistry.getTargetContext()
        db = Room.inMemoryDatabaseBuilder(context, ItemsDatabase::class.java).build()
        itemDao = db.itemDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb()
    {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeItemAndRead()
    {

    }
}
