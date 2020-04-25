package note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import archcomps.traning.R
import note.MyAdapterNote.ViewHolder

class MyAdapterNote(var note: List<Note>, val itemviewonclicklistener: View.OnClickListener)
    : RecyclerView.Adapter<ViewHolder>() {


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById(R.id.card_view) as CardView
        val title = itemView.findViewById(R.id.title) as TextView
        val description = itemView.findViewById(R.id.description) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // invoke layout Manager
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_note, parent, false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = note[position]
        holder.cardView.setOnClickListener(itemviewonclicklistener)
        holder.cardView.tag = position
        holder.title.text = note.title
        holder.description.text = note.body
}

override fun getItemCount(): Int = note.size
}