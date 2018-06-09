package mustafa.ahmad.com.androidarchitecturecomponents.Model.DataAccessObjects

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.Item

@Dao
interface ItemDao {

    @Insert
    fun insert(pItem: Item)

    @Delete
    fun delete(pItem: Item)

    @Query("SELECT * FROM Items")
    fun getItems(): LiveData<List<Item>>

    @Query("SELECT title , body FROM Items WHERE title LIKE :pTitle")
    fun getOneItem(pTitle:String):LiveData<List<Item>>
}