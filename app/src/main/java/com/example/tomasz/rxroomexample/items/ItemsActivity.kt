package com.example.tomasz.rxroomexample.items

import android.os.Bundle
import android.os.Handler
import com.example.tomasz.rxroomexample.BaseActivity
import com.example.tomasz.rxroomexample.utils.Utils
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

        presenter.onCreate(view)

        insertValuesToDatabase()
    }

    private fun insertValuesToDatabase()
    {
        presenter.onInsert(Utils.items[0])
        Handler().postDelayed({ presenter.onInsert(Utils.items[1]) }, 3000)
        Handler().postDelayed({ presenter.onInsert(Utils.items[2]) }, 7000)
        Handler().postDelayed({ presenter.onInsert(Utils.items[3]) }, 10000)
    }

    override fun onDestroy()
    {
        presenter.onDelete(Utils.items[0])
        presenter.onDelete(Utils.items[1])
        presenter.onDelete(Utils.items[2])
        presenter.onDelete(Utils.items[3])
        presenter.onDestroy()
        super.onDestroy()
    }
}
