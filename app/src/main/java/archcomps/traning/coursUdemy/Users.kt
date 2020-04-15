package archcomps.traning.coursUdemy

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Users (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var name: String,
    var age : Int
)