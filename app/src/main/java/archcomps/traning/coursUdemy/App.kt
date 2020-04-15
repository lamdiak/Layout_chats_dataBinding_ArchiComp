package archcomps.traning.coursUdemy

import android.app.Application
import androidx.room.Room

class App: Application() {

    companion object {
        lateinit var dataBase : AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        dataBase = Room.databaseBuilder(this,  AppDataBase::class.java, "dataBaseName")
            .addMigrations(MIGRATION_1_2)
            .build()
    }
}