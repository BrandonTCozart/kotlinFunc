package com.example.koylinfasten.DBdataModel

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class realmPostModelObject(): RealmObject {
    var posttitle: String = ""
    var postText: String = ""
    @PrimaryKey var post_Id: String = ObjectId.create().toString()
    var postTime: String = ""

}