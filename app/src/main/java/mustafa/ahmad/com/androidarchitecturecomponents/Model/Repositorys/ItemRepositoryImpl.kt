package mustafa.ahmad.com.androidarchitecturecomponents.Model.Repositorys

import android.arch.lifecycle.LiveData
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Database.ItemDatabase
import android.arch.persistence.room.Room
import android.util.Log
import mustafa.ahmad.com.androidarchitecturecomponents.Application.MyApp
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.Item
import org.jetbrains.anko.doAsync



class ItemRepositoryImpl// constructor
private constructor() : ItemRepository {
    private var itemDB: ItemDatabase? = null
    private val TAG = this.javaClass.name
    private val DATABASE_NAME = "ItemDatabase"

    init {
        initDB()
    }

    private fun initDB() {
        Log.e(TAG, "_DataBaseInit")
        itemDB = Room.databaseBuilder(MyApp.context,
                ItemDatabase::class.java ,
                DATABASE_NAME ).build()
    }

    override fun addItem(item: Item) {
        Log.e(TAG, "_ItemIsAddedToDB")
        dataBaseOperation(item, INSERT_OPERATION)
    }

    override fun deleteItem(item: Item) {
        Log.e(TAG, "_ItemIsDeletedFromDB")
        dataBaseOperation(item, DELETE_OPERATION)
    }

    override fun getItems(): LiveData<List<Item>> {
        Log.e(TAG, "_GetItemsFromDB")
        return itemDB?.itemDao()?.getItems()!!
    }

    override fun getOneItem(pTitle: String): LiveData<List<Item>> {
        return itemDB?.itemDao()?.getOneItem(pTitle)!!
    }

    private fun dataBaseOperation(item: Item, operation: Int){
        // Async
        doAsync {
            if (operation == INSERT_OPERATION) {
                itemDB?.itemDao()?.insert(item)
            } else {
                itemDB?.itemDao()?.delete(item)
            }
        }
    }


    companion object {

        private val repository = ItemRepositoryImpl()

        // operations constants
        private val INSERT_OPERATION = 0
        private val DELETE_OPERATION = 1

        val instance: ItemRepository
            get() = repository
    }

}