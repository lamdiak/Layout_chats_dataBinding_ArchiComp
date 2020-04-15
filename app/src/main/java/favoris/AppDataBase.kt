package favoris

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Folder::class, Bookmark::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun folderDao(): FolderDao
    abstract fun bookMarkDao(): BookmarkDao

}