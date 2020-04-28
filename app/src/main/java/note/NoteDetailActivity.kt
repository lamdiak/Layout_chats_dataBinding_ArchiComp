package note

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import archcomps.traning.R
import retrofit2.http.DELETE


class NoteDetailActivity : AppCompatActivity() {

    companion object {
        val REQUEST_EDIT_NOTE = 1
        val EXTRA_NOTE = "note"
        val EXTRA_NOTE_INDEX = "noteIndex"

        val EDIT_NOTE = "DiscoverArchitectureComponents.app.src.main.java.note.EDIT"
        val DELETE_NOTE = "DiscoverArchitectureComponents.app.src.main.java.note.DELETE"

    }

    lateinit var note: Note
    var noteIndex: Int = -1
    lateinit var textTitle: TextView
    lateinit var textBody: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        note = intent.getParcelableExtra(EXTRA_NOTE)
        noteIndex = intent.getIntExtra(EXTRA_NOTE_INDEX, -1)
        textTitle = findViewById(R.id.editText5)
        textBody = findViewById(R.id.editText6)
        textTitle.text = note.title
        textBody.text = note.body


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save -> {
                saveNoteDetail()
                return true
            }
            R.id.delete -> {
                deleteNoteDetail()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun saveNoteDetail() {
        note.title = textTitle.text.toString()
        note.body = textBody.text.toString()
        intent = Intent(EDIT_NOTE)
        intent.putExtra(EXTRA_NOTE, note)
        intent.putExtra(EXTRA_NOTE_INDEX, noteIndex)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun deleteNoteDetail() {

        // Instance of DialogFragment
        val dialogFragment = note.title?.let { ConfirmDeleteNoteDialogFragment(it) }
        dialogFragment?.listener = object : ConfirmDeleteNoteDialogFragment.ListenerDeleteNoteDialog {
            override fun positiveButtonClick() {
                // Ajout d'une action dans l'intent (DELETE_NOTE)
                intent = Intent(DELETE_NOTE)
                intent.putExtra(EXTRA_NOTE_INDEX, noteIndex)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

            override fun negativeButtonClick() {
            }
        }
        dialogFragment?.show(supportFragmentManager,"ConfirmDeleteNoteDialogFragment")

    }
}
