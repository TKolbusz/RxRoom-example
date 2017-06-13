package com.example.tomasz.rxroomexample

interface Presenter<in T>
{
    fun onCreate(view: T)
    fun onDestroy()
}