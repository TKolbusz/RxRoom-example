package com.example.tomasz.rxroomexample.items

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(ItemsSubcomponent::class))
abstract class ItemsModule constructor(private val activity: ItemsActivity)
{
    @Binds
    @IntoMap
    @ActivityKey(ItemsActivity::class)
    internal abstract fun bindsItemsActivityInjectorFactory(builder: ItemsSubcomponent.Builder): AndroidInjector.Factory<out Activity>
}
