package com.example.koylinfasten.ViewModels

import androidx.lifecycle.ViewModel
import androidx.work.*
import com.example.koylinfasten.DBdataModel.realmPostModelObject
import com.example.koylinfasten.classes.Post
import com.example.koylinfasten.classes.WorkerWorking
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import java.util.*
import kotlin.collections.ArrayList

class PostModel: ViewModel() {
    lateinit var realm: Realm


    // Automatic post //
    fun addPosts(title: String, content: String){
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




    fun getPosts():ArrayList<Post>{
        var posts : ArrayList<Post> = ArrayList()
        val config = RealmConfiguration.Builder(schema = setOf(realmPostModelObject::class)).build()
        realm = Realm.open(config)

        var allPosts: RealmResults<realmPostModelObject> = realm.query<realmPostModelObject>().find()

        for (position in allPosts){
            posts.add(Post(position.posttitle, position.postText, position.postTime))
        }
        realm.close()
        return posts
    }

    fun deletePost(position: Int){
        val config = RealmConfiguration.Builder(schema = setOf(realmPostModelObject::class))
            .build()
        realm = Realm.open(config)

        realm.writeBlocking {
            val writeTransactionItems = query<realmPostModelObject>().find()
            delete(writeTransactionItems[position])
        }
        realm.close()
    }



    // Posts when the Internet is on //
    fun sendPostInfo(title: String, content: String){

        val uploadDataConstraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

        val inputData = Data.Builder()
            .putString("postTitle", title)
            .putString("postContent", content)
            .build()


        val uploadWorkRequest = OneTimeWorkRequestBuilder<WorkerWorking>()
            .setConstraints(uploadDataConstraints)
            .setInputData(inputData)
            .build()

        WorkManager.getInstance().enqueue(uploadWorkRequest)



    }


}