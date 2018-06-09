package mustafa.ahmad.com.androidarchitecturecomponents.Model.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import mustafa.ahmad.com.androidarchitecturecomponents.Model.DataAccessObjects.ItemDao
import mustafa.ahmad.com.androidarchitecturecomponents.Model.DataAccessObjects.UserDao
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.Item
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.User

@Database(entities = arrayOf(Item::class , User::class), version = 2 , exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
    abstract fun userDao(): UserDao
}