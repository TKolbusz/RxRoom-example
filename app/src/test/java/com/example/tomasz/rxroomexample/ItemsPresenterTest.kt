package com.example.tomasz.rxroomexample

import com.example.tomasz.rxroomexample.items.ItemsPresenter
import com.example.tomasz.rxroomexample.items.ItemsView
import com.example.tomasz.rxroomexample.room.Item
import com.example.tomasz.rxroomexample.room.ItemDao
import de.jodamob.kotlin.testrunner.KotlinTestRunner
import io.reactivex.Flowable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as When

@RunWith(KotlinTestRunner::class)
class ItemsPresenterTest
{
    private lateinit var view: ItemsView
    private lateinit var dao: ItemDao

    private lateinit var presenter: ItemsPresenter

    @Before
    fun setup()
    {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.io() }
        dao = mock(ItemDao::class.java)
        view = mock(ItemsView::class.java)
        presenter = ItemsPresenter(dao)
    }

    @Test
    fun onGetItemsTest()
    {
        val list = ArrayList<Item>()
        When(dao.getAllItems()).thenReturn(Flowable.just(list))
        presenter.onCreate(view)

        verify(view).showData(list)
    }

}
