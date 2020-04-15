package favoris

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FolderDao {


    /**
     * Usage :
     *  dao.InsertFolder(folder)
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertFolder(folder: Folder)

    @Update
    fun UpdateFolder(folder: Folder)


    @Delete
    fun DeleteFolder(folder: Folder)

    /**
     * Usage :
     * getAllFolder().observe(context:this , Observer {folderList -> ....}
     */
    @Query("SELECT * FROM folders")
    fun getAllFolder() : LiveData<List<Folder>>

    @Query("""
        SELECT * FROM folders 
        INNER JOIN bookmarks on folderId=id
        INNER JOIN folders on id = folderId
        WHERE id = folderId
    """)
    fun getAllBookMark() : LiveData<List<Bookmark>>

}