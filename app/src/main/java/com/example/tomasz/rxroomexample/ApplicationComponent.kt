package com.example.tomasz.rxroomexample

import android.arch.persistence.room.Room
import android.content.Context
import com.example.tomasz.rxroomexample.items.ItemsModule
import com.example.tomasz.rxroomexample.room.ItemDao
import com.example.tomasz.rxroomexample.room.ItemsDatabase
import dagger.Component
import dagger.Module
import dagger.Provides

@ApplicationScope
@Component(modules = arrayOf(ApplicationComponent.ApplicationModule::class, ItemsModule::class))
interface ApplicationComponent
{
    fun inject(application: InjectableApplication)

    @Module
    class ApplicationModule(val context: Context)
    {
        @ApplicationScope
        @Provides
        fun context(): Context = context

        @ApplicationScope
        @Provides
        fun database(context: Context): ItemsDatabase =
                Room.databaseBuilder(context, ItemsDatabase::class.java, "roomdb").build()

        @ApplicationScope
        @Provides
        fun itemDao(database: ItemsDatabase): ItemDao = database.itemDao()
    }
}
