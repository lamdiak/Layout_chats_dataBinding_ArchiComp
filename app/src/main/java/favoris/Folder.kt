package favoris

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "folders", indices = [
            Index(value = ["name"], unique = true)])

data class Folder(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    @ColumnInfo(name="name")
    val name: String
)