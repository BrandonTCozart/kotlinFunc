package com.example.koylinfasten.ViewModels

import androidx.lifecycle.ViewModel
import com.example.koylinfasten.classes.Post

class PostModel: ViewModel() {

    fun getPosts():ArrayList<Post>{
        var posts : ArrayList<Post> = ArrayList()
        posts.add(Post("a","b","c"))
        return posts
    }

}