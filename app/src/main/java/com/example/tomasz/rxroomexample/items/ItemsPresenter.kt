package com.example.tomasz.rxroomexample.items

import com.example.tomasz.rxroomexample.Presenter
import com.example.tomasz.rxroomexample.room.Item
import com.example.tomasz.rxroomexample.room.ItemDaoCoroutines
import com.example.tomasz.rxroomexample.room.ItemDaoRx
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ItemsPresenter @Inject constructor(
    private val itemDaoRx: ItemDaoRx,
    private val itemDaoCoroutines: ItemDaoCoroutines,
    ) : Presenter<ItemsView>
{
    private val disposables: CompositeDisposable = CompositeDisposable()
    private lateinit var view: ItemsView

    override fun onCreate(view: ItemsView)
    {
        this.view = view
        disposables.addAll(
                onGetItems()
                //onGetItemsAt()
        )
    }


    override fun onDestroy() = disposables.clear()

    private fun onGetItems() = itemDaoRx.getAllItems()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::showData, {
                throwable ->
                view.showLoadingDataError(throwable.localizedMessage)
            })

    private fun onGetItemsAt() = itemDaoRx.getItemsAt("Desk")
            .filter { items -> items.isNotEmpty() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::showData, {
                throwable ->
                view.showLoadingDataError(throwable.localizedMessage)
            })

    fun onInsert(item: Item)
    {
        val disposable = itemDaoRx.insertItem(item)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({view.showItemAddedMessage()},{error ->
                view.showError(error.localizedMessage)
            } )

        this.disposables.add(disposable)
    }

    fun onDelete(itemId: Long)
    {
        val disposable = itemDaoRx.deleteItem(itemId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({view.showItemDeletedMessage()},{error ->
                view.showError(error.localizedMessage)
            } )

        this.disposables.add(disposable)
    }
}
