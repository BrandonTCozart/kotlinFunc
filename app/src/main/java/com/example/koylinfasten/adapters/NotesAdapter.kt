package com.example.koylinfasten.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.koylinfasten.R
import com.example.koylinfasten.classes.Note

class notesAdapter (val mNotes: List<Note>) : RecyclerView.Adapter<notesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val noteTitleBox = itemView.findViewById<TextView>(R.id.textTitle)
        val noteTextBox = itemView.findViewById<TextView>(R.id.textViewText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.note_layout, parent, false)

        return ViewHolder(contactView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val note: Note = mNotes.get(position)

        val textViewTitle = holder.noteTitleBox
        textViewTitle.text = note.title

        val textViewText = holder.noteTextBox
        textViewText.text = note.noteText

    }

    override fun getItemCount(): Int {
        return mNotes.size
    }

}