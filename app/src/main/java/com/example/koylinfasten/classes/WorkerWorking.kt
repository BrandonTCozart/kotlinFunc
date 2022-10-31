package com.example.koylinfasten.classes

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.koylinfasten.DBdataModel.realmPostModelObject
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import java.util.*

class WorkerWorking (appContext: Context, workerParams: WorkerParameters):Worker(appContext, workerParams) {



    override fun doWork(): Result {
        val title = inputData.getString("postTitle")
        val content = inputData.getString("postContent")

        taskOne(content.toString(), title.toString())

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }




    private fun taskOne(content:String, title: String){
        lateinit var realm: Realm

        val config = RealmConfiguration.Builder(schema = setOf(realmPostModelObject::class)).build()
        realm = Realm.open(config)

        var calendar: Calendar = Calendar.getInstance()

        realm.writeBlocking {
            copyToRealm(realmPostModelObject().apply {
                postText = content
                posttitle = title
                postTime = calendar.time.toString()
            })
        }
        realm.close()

    }
}