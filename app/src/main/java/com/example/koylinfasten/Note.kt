package com.example.koylinfasten

 class Note (var title: String, var noteText: String, override var creationDate: String, override var creationTime: String) :Creation{

  companion object{

    fun createNotesList(numNotes: Int): ArrayList<Note>{
     val notez = ArrayList<Note>()
     for (i in 1..numNotes){

      notez.add(Note("Note $i", " Random Text ", "", ""))

     }
     return notez
    }
  }



}