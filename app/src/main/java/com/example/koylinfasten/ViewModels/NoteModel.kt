package com.example.koylinfasten.ViewModels

import androidx.lifecycle.ViewModel
import com.example.koylinfasten.DBdataModel.realmDataModelObject
import com.example.koylinfasten.classes.Note
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import java.util.*
import kotlin.collections.ArrayList

class NoteModel: ViewModel() {

    lateinit var realm: Realm
    //lateinit var notes: ArrayList<Note>



    fun writeNewNoteToDatabase(titleOfNew: String,textOfNew: String){

        val config = RealmConfiguration.Builder(schema = setOf(realmDataModelObject::class))
            .build()
        realm = Realm.open(config)

        var calendar: Calendar = Calendar.getInstance()

        realm.writeBlocking {
            copyToRealm(realmDataModelObject().apply {
                title = titleOfNew
                noteText = textOfNew
                creationTime = calendar.time.toString()
            })
        }
        realm.close()
    }



    fun updateListOfNotes(): ArrayList<Note> {

        val config = RealmConfiguration.Builder(schema = setOf(realmDataModelObject::class))
            .build()
        realm = Realm.open(config)

        var items: RealmResults<realmDataModelObject> = realm.query<realmDataModelObject>().find()
        var notez: ArrayList<Note> = ArrayList()
        for(position in items){
            notez.add(Note(position.title, position.noteText, position.note_Id,position.creationTime))
        }
        realm.close()
        return notez
    }





    fun deleteNote(position:Int){
        val config = RealmConfiguration.Builder(schema = setOf(realmDataModelObject::class))
            .build()
        realm = Realm.open(config)

        realm.writeBlocking {
            val writeTransactionItems = query<realmDataModelObject>().find()
            delete(writeTransactionItems[position])
        }
        realm.close()
    }



    fun validateNotEmpty(s1: String, s2: String): Boolean{
        return !s1.isEmpty() && !s2.isEmpty()

    }

}