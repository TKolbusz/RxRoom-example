package com.example.tomasz.rxroomexample

import android.content.Context
import androidx.room.Room
import com.example.tomasz.rxroomexample.items.ItemsModule
import com.example.tomasz.rxroomexample.room.ItemDaoCoroutines
import com.example.tomasz.rxroomexample.room.ItemDaoRx
import com.example.tomasz.rxroomexample.room.ItemsDatabase
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule

@ApplicationScope
@Component(modules = arrayOf(AndroidInjectionModule::class,ApplicationComponent.ApplicationModule::class, ItemsModule::class))
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
        fun itemDaoRx(database: ItemsDatabase): ItemDaoRx = database.itemDaoRx()
        @ApplicationScope
        @Provides
        fun itemDaoCoroutines(database: ItemsDatabase): ItemDaoCoroutines = database.itemDaoCoroutines()
    }
}
