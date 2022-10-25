package com.example.koylinfasten.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.koylinfasten.R
import com.example.koylinfasten.classes.Note
import org.w3c.dom.Text

class notesAdapter (val mNotes: List<Note>) : RecyclerView.Adapter<notesAdapter.ViewHolder>() {


    // On Click Listener //
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int){

        }

        fun onDeleteButtonClick(position: Int){

        }
    }

   fun setOnItemClickListener(listener: onItemClickListener){
       mListener = listener
   }


    // On Click Listener //


    inner class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val noteTitleBox = itemView.findViewById<TextView>(R.id.textTitle)
        val noteTextBox = itemView.findViewById<TextView>(R.id.textViewText)
        val noteTimeTextBox = itemView.findViewById<TextView>(R.id.textView2)

        val deleteButton = itemView.findViewById<Button>(R.id.button9)

        // on Click Listener //
        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }


            deleteButton.setOnClickListener {
                listener.onDeleteButtonClick(adapterPosition)
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

        val textViewTime = holder.noteTimeTextBox
        textViewTime.text = note.creationTime
    }

    override fun getItemCount(): Int {
        return mNotes.size
    }

}