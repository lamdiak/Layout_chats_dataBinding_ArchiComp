package note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import archcomps.traning.R


class NoteDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_NOTE = "note"
        val EXTRA_NOTE_INDEX = "noteIndex"
    }

    lateinit var note: Note
    var noteIndex: Int = -1
    lateinit var textTitle: TextView
    lateinit var textBody: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        note = intent.getParcelableExtra(EXTRA_NOTE)
        noteIndex = intent.getIntExtra(EXTRA_NOTE_INDEX, -1)
        textTitle = findViewById(R.id.editText5)
        textBody = findViewById(R.id.editText6)
        textTitle.text = note.title
        textBody.text = note?.body


    }
}
