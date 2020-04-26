package note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import archcomps.traning.R

class NoteListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapterNote: MyAdapterNote
    private lateinit var viewManager : RecyclerView.LayoutManager
    lateinit var note: MutableList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

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

    override fun onClick(v: View) {
        if (v.tag!=null){
            Toast.makeText(this, "${v.tag}", Toast.LENGTH_SHORT).show()
            showNoteDetail(v.tag as Int)
        }
    }

    private fun showNoteDetail(noteIndex: Int) {
        var notes = note[noteIndex]
        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE,notes)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX,noteIndex)
        startActivity(intent)
    }
}
