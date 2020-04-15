package favoris

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "bookmarks",
        foreignKeys =[
            ForeignKey(entity = Folder::class,
                parentColumns = ["id"],
                childColumns = ["folderId"],
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.NO_ACTION

                )]
        )
data class Bookmark (
    @PrimaryKey(autoGenerate = true)
        val id : Long,
        val folderId: Long,
        val name: String,
        val url: String
)