package mustafa.ahmad.com.androidarchitecturecomponents.Model.Repositorys

import android.arch.lifecycle.LiveData
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.Item


interface ItemRepository {

    fun addItem(item: Item)

    fun deleteItem(item: Item)

    fun getItems(): LiveData<List<Item>>

    fun getOneItem(pTitle:String): LiveData<List<Item>>
}