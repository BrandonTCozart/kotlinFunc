package com.example.koylinfasten

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class todoAdpater (private val mReminder: List<Todo>):RecyclerView.Adapter<todoAdpater.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val checkBoxTodo = itemView.findViewById<CheckBox>(R.id.checkBox2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.todo_layout, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo: Todo = mReminder.get(position)

        val checkboxTodo = holder.checkBoxTodo
        checkboxTodo.text = todo.todoText
    }

    override fun getItemCount(): Int {
        return mReminder.size
    }

}