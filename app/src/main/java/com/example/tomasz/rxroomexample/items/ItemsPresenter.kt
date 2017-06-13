package com.example.tomasz.rxroomexample.items

import android.util.Log
import com.example.tomasz.rxroomexample.Presenter
import com.example.tomasz.rxroomexample.room.Item
import com.example.tomasz.rxroomexample.room.ItemDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ItemsPresenter @Inject constructor(private val itemDao: ItemDao) : Presenter<ItemsView>
{
    private val disposables: CompositeDisposable = CompositeDisposable()
    private lateinit var view: ItemsView

    override fun onCreate(view: ItemsView)
    {
        this.view = view
        disposables.addAll(
                onGetItems()
        )
    }

    override fun onDestroy() = disposables.clear()

    private fun onGetItems() =
            itemDao.getAllItems()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(view::showData,
                            { t -> view.showLoadingDataError(t.localizedMessage) })

    fun onInsert(item: Item)
    {
        Observable.just(item)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({ item ->
                    itemDao.insertItem(item)
                    Log.d("Presenter", "item inserted: " + item)
                }, { throwable -> view.showInsertingDataError(throwable.localizedMessage) })
    }
}
