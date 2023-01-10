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
) : Presenter<ItemsView> {
    private lateinit var view: ItemsView

    override fun onCreate(view: ItemsView) {
        this.view = view
        onGetItems()
    }

    override fun onDestroy() {

    }

    private fun onGetItems() {
        CoroutineScope(Dispatchers.IO).launch {
            val items = itemDaoCoroutines.getAllItems()
            CoroutineScope(Dispatchers.Main).launch{
                view.showData(items)
            }
        }
    }
    fun onInsert(item: Item) {
        CoroutineScope(Dispatchers.IO).launch {
            itemDaoCoroutines.insertItem(item)
            CoroutineScope(Dispatchers.Main).launch{
                view.showItemAddedMessage()
            }
            onGetItems()
        }
    }

    fun onDelete(itemId: Long) {
        CoroutineScope(Dispatchers.IO).launch {
            itemDaoCoroutines.deleteItem(itemId)
            CoroutineScope(Dispatchers.Main).launch{
                view.showItemDeletedMessage()
            }
            onGetItems()
        }
    }
}
