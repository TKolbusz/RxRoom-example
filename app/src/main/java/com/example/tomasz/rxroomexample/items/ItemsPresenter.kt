package com.example.tomasz.rxroomexample.items

import com.example.tomasz.rxroomexample.Presenter
import com.example.tomasz.rxroomexample.room.Item
import com.example.tomasz.rxroomexample.room.ItemDaoCoroutines
import com.example.tomasz.rxroomexample.room.ItemDaoRx
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    fun loadData(){
        /*CoroutineScope(Dispatchers.IO).launch {
         var allItems = itemDaoCoroutines.getAllItems()
         CoroutineScope(Dispatchers.Main).launch {
             view.showData(allItems)
         }
     }*/
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
        Observable.just(item)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({ item ->
                    itemDaoRx.insertItem(item)
                }, { throwable -> view.showInsertingDataError(throwable.localizedMessage) })
    }

    fun onDelete(itemId: Long)
    {
        Observable.just(itemId)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(itemDaoRx::deleteItem
                        , { throwable ->
                    view.showInsertingDataError(throwable.localizedMessage)
                })
    }
}
