package com.example.tomasz.rxroomexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        injectMembers()
    }

    protected abstract fun injectMembers()
}
