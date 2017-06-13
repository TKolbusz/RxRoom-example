package com.example.tomasz.rxroomexample.items

import android.os.Bundle
import com.example.tomasz.rxroomexample.BaseActivity
import com.example.tomasz.rxroomexample.room.Item
import dagger.android.AndroidInjection
import javax.inject.Inject

class ItemsActivity : BaseActivity()
{
    @Inject
    lateinit var presenter: ItemsPresenter
    @Inject
    lateinit var view: ItemsView

    override fun injectMembers() = AndroidInjection.inject(this)

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(view)
        setSupportActionBar(view.getToolbar())

        insertValuesToDatabase()

        presenter.onCreate(view)
    }

    private fun insertValuesToDatabase()
    {
        val item1 = Item("Pencil", "Table", "1", "sharpest pencil in the world")
        val item2 = Item("Screen", "Desk", "1", "broken screen")
        val item3 = Item("Chair", "Bedroom", "2", "old chairs")
        presenter.onInsert(item1)
        presenter.onInsert(item2)
        presenter.onInsert(item3)
    }

    override fun onDestroy()
    {
        presenter.onDestroy()
        super.onDestroy()
    }
}
