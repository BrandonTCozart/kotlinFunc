package com.example.koylinfasten.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.koylinfasten.R
import com.example.koylinfasten.classes.Note

class notesAdapter (val mNotes: List<Note>) : RecyclerView.Adapter<notesAdapter.ViewHolder>() {


    // On Click Listener //
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int){

        }
    }

   fun setOnItemClickListener(listener: onItemClickListener){

       mListener = listener
   }
    // On Click Listener //


    inner class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val noteTitleBox = itemView.findViewById<TextView>(R.id.textTitle)
        val noteTextBox = itemView.findViewById<TextView>(R.id.textViewText)

        // on Click Listener //
        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
        // On Click Listener //
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.note_layout, parent, false)

        return ViewHolder(contactView, /* On click Listener */ mListener)

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