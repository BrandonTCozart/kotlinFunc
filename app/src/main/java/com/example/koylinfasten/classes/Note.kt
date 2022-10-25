package com.example.koylinfasten.classes

import com.example.koylinfasten.interfaces.Creation

class Note (var title: String,
            var noteText: String,
            var noteID: String,
            override var creationTime: String) :
    Creation {


  companion object{
    fun createNotesList(numNotes: Int): ArrayList<Note>{
     val notez = ArrayList<Note>()
     for (i in 1..numNotes){

      notez.add(Note("Note $i", " Random Text ", "", " "))

     }
     return notez
    }
  }



}