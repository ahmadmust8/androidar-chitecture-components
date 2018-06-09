package mustafa.ahmad.com.androidarchitecturecomponents.ViewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.Item
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Repositorys.ItemRepositoryImpl

class MainActivityViewModel : ViewModel() {

    private val TAG = this.javaClass.name

    private var listItem:LiveData<List<Item>>?=null

    fun getListItems():LiveData<List<Item>>{

        if (listItem == null) {
            Log.e(TAG, "_ListItemsIsNULL")
            listItem = MutableLiveData<List<Item>>()
            loadItemsFromRepository()
        }
        Log.e(TAG, "_ReturningFromViewModel")
        return listItem as LiveData<List<Item>>
    }

    private fun loadItemsFromRepository(){
        listItem = ItemRepositoryImpl.instance.getItems()
    }

}