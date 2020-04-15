package archcomps.traning.coursUdemy

import android.graphics.Bitmap
import androidx.room.*

data class Adress(
        var street: String = "",
        var ctiy: String = "",
        var country : String= ""
)

@Entity
data class Compagny(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        var name: String
)


// les lien de foreignKey bien définis
@Entity(tableName = "users",
            indices = [Index(value = ["name","age"], unique = true)],
            foreignKeys = [ForeignKey(entity = Compagny::class,
            parentColumns = ["id"],
            childColumns =["compagnyId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.NO_ACTION)]
        )
data class User (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name="full_name")
    var name: String,
    var age : Int,
    var comagnyId: Int?,
    @Embedded
    var adress: Adress = Adress(),
    @Ignore
    var picture: Bitmap
)