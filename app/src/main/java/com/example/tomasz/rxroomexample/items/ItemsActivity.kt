package com.example.tomasz.rxroomexample.items

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.tomasz.R
import com.example.tomasz.rxroomexample.BaseActivity
import com.example.tomasz.rxroomexample.utils.Utils
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

        view.getFAB().setOnClickListener({ presenter.onInsert(Utils.randomItem()) })
        view.onDeleteItemCallback =  {id:Long -> presenter.onDelete(id)}
    }

    override fun onDestroy()
    {
        presenter.onDestroy()
        super.onDestroy()
    }
}
