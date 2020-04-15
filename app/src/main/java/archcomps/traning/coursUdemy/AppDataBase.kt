package archcomps.traning.coursUdemy

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [UsersDao::class], version = 2)
abstract class AppDataBase: RoomDatabase() {

    abstract fun userDao() : UsersDao
}

// Pour faire une migration de la BDD
val MIGRATION_1_2 = object : Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
      database.execSQL("ALTER TABLE `User` ADD email TEXT NOT NULL DEFAULT ''")
    }

}