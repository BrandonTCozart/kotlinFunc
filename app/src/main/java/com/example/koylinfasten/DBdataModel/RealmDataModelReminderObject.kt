package com.example.koylinfasten.DBdataModel

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class realmDataModelReminderObject() : RealmObject {
    var textRemind: String = ""
    var timeRemind: String? = ""
    @PrimaryKey var reminderID: String = ObjectId.create().toString()
    var creationTime: String = ""
}
