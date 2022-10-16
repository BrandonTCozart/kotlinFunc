package com.example.koylinfasten

class Todo(var todoText: String, var completed: Boolean, override var creationDate: String, override var creationTime: String):Creation {

               companion object{
                   fun createReminderList(numTodo: Int): ArrayList<Todo>{
                       val todos = ArrayList<Todo>()
                       for (i in 1..numTodo){

                           todos.add(Todo("",false, "", ""))

                       }
                       return todos
                   }
               }
}