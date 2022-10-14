package com.example.koylinfasten

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class reminderAdapter(private val mReminder: List<Reminder>) : RecyclerView.Adapter<reminderAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val checkboxReminder = itemView.findViewById<CheckBox>(R.id.checkBox)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.reminder_layout, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reminder: Reminder = mReminder.get(position)

        val checkboxReminder = holder.checkboxReminder
        checkboxReminder.text = reminder.textRemind


    }

    override fun getItemCount(): Int {
        return mReminder.size
    }

}