package mustafa.ahmad.com.androidarchitecturecomponents.Model.DataAccessObjects

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import mustafa.ahmad.com.androidarchitecturecomponents.Model.Entities.User

@Dao
interface UserDao {

    @Insert
    fun insert(pUser: User)

    @Delete
    fun delete(pUser: User)

    @Query("SELECT name FROM Users WHERE name LIKE :pUser")
    fun getUser(pUser: User)

    @Query("SELECT * FROM Users")
    fun getAllUsers():LiveData<List<User>>
}