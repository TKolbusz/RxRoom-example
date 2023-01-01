package com.example.tomasz.rxroomexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        injectMembers()
    }

    protected abstract fun injectMembers()
}
