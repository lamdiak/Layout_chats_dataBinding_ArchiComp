package archcomps.traning.coursUdemy

import androidx.lifecycle.LiveData
import androidx.room.*
import archcomps.traning.coursUdemy.Users

//data class NameAgeTuple(val name: String, val age: Int)


@Dao
interface UsersDao {
//
//    /**
//     * Usage
//     * dao.createUser(user)
//     */
//    @Insert
//    fun creatUser(usersDAO: UsersDAO)
//
//    /**
//     * Usage :
//     *  val id : dao.insertUserReturnId(user)
//     */
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertUserReturnId(usersDAO: UsersDAO) : Long
//
//    fun insertUsers(user: List<UsersDAO>) : List<Long>
//
//    fun insertUsers(vararg user : UsersDAO) : Array<Int>
//
//    /**
//     *  Usage :
//     *  dao.update(users)
//     */
//    @Update
//    fun update(usersDAO: UsersDAO)
//
//    @Delete
//    fun deleteUser(usersDAO: UsersDAO)
//
//
//    /**
//     * Usage :
//     * get select users in table
//     */
//    @Query("SELECT * FROM usersdao")
//    fun getAllUsers() : List<UsersDAO>
//
//
//    /**
//     * dao.gegtUserById(3).observe(this, Observer {user -> ...})
//     */
//    @Query("SELECT * FROM usersdao WHERE id = :userId")
//    fun getUserById(userId: UsersDAO) : LiveData<UsersDAO>
//
//    @Query("SELECT * FROM usersdao WHERE name LIKE :name AND age > :minAge")
//    fun getUsersByNameAndOlderthan(name: String, minAge: Int) : LiveData<List<UsersDAO>>
//
//    //  @Query("SELECT * FROM usersdao WHERE name IN (:name)")
//
//    //@Query("SELECT name, age FROM userdao")
//    fun getNameAgeTuple() : LiveData<List<NameAgeTuple>>

    @Insert
    fun insertUer(user: Users) : Long

    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<List<Users>>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: Int) : LiveData<Users>
}