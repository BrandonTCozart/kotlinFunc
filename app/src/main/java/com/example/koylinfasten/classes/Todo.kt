package com.example.koylinfasten.classes

import com.example.koylinfasten.interfaces.Creation

class Todo(var todoText: String, var completed: Boolean,var todoID: String, override var creationTime: String):
    Creation {

               companion object{
                   fun createReminderList(numTodo: Int): ArrayList<Todo>{
                       val todos = ArrayList<Todo>()
                       for (i in 1..numTodo){

                           todos.add(Todo("Random Task",false, "",""))

                       }
                       return todos
                   }
               }
}