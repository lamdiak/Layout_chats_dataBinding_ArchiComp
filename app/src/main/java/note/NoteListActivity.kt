package note

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import archcomps.traning.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import note.NoteDetailActivity.Companion.DELETE_NOTE
import note.NoteDetailActivity.Companion.EDIT_NOTE
import note.NoteDetailActivity.Companion.EXTRA_NOTE
import note.NoteDetailActivity.Companion.EXTRA_NOTE_INDEX
import note.NoteDetailActivity.Companion.REQUEST_EDIT_NOTE

class NoteListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapterNote: MyAdapterNote
    private lateinit var viewManager : RecyclerView.LayoutManager
    lateinit var note: MutableList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // FAB
        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener(this)

        // My List
        note = mutableListOf()
        note.add(Note("Ma première Note 1", "J'ai aimé une femme que j'aimerai.."))
        note.add(Note("Mon amour ", "Ceci n'est pas une déclaration non plus un aveux"))

        recyclerView = findViewById(R.id.recycler_view)
        viewManager = LinearLayoutManager(this)
        myAdapterNote = MyAdapterNote(note, this)

        recyclerView.apply {
            layoutManager = viewManager
            adapter = myAdapterNote
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK || data==null){
           return
       }
        when(requestCode){
            REQUEST_EDIT_NOTE -> processEditNoteResult(data)
        }

    }

    private fun processEditNoteResult(data: Intent) {
        val noteIndex = data.getIntExtra(EXTRA_NOTE_INDEX, -1)
        val notes = data.getParcelableExtra<Note>(EXTRA_NOTE)
        when(data.action) {
            EDIT_NOTE -> {
                saveNote(notes,noteIndex)
            }
             DELETE_NOTE -> {
                 deleteNoteDetail(noteIndex)
             }
        }
    }

    private fun deleteNoteDetail(noteIndex: Int) {
        if(noteIndex <0 ){
            return
        }
        val notes= note.removeAt(noteIndex)
        myAdapterNote.notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        if (v.tag!=null){
           // Toast.makeText(this, "${v.tag}", Toast.LENGTH_SHORT).show()
            showNoteDetail(v.tag as Int)
        }else {
            when(v.id){
                R.id.floatingActionButton -> createNewNote()
            }
        }
    }

    private fun saveNote(notes: Note, noteIndex: Int) {
        if (noteIndex < 0){
            note.add(0, notes)
        } else {
            note[noteIndex] = notes
        }
        myAdapterNote.notifyDataSetChanged()
    }

    private fun createNewNote() {
        showNoteDetail(-1)
    }


    private fun showNoteDetail(noteIndex: Int) {
        var notes = if(noteIndex < 0) Note() else note[noteIndex]
        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra(EXTRA_NOTE,notes)
        intent.putExtra(EXTRA_NOTE_INDEX,noteIndex)
        startActivityForResult(intent, REQUEST_EDIT_NOTE)
    }

}
