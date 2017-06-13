package com.example.tomasz.rxroomexample.items

import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface ItemsSubcomponent : AndroidInjector<ItemsActivity>
{
    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ItemsActivity>()
}
