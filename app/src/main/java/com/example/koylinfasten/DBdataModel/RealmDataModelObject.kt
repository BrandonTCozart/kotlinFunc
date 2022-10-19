package com.example.koylinfasten.DBdataModel

import android.content.ClipData
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class realmDataModelObject() : RealmObject {
    var title: String = ""
    var noteText: String = ""
    @PrimaryKey var note_Id: String = ObjectId.create().toString()
    var creationTime: String = ""

    constructor(noteId: String = ""): this(){
        note_Id = noteId
    }

}


