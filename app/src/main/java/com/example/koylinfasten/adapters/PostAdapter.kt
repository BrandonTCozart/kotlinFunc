package com.example.koylinfasten.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.koylinfasten.R
import com.example.koylinfasten.classes.Post

class PostAdapter(private val mPostArray: ArrayList<Post>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val postTitle = itemView.findViewById<TextView>(R.id.textView4)
        val postDate = itemView.findViewById<TextView>(R.id.textView5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.note_layout, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post: Post = mPostArray.get(position)

        val postTitle1 = holder.postTitle
        postTitle1.text = post.postTitle

        val postDate = holder.postDate
        postDate.text = post.postScheduleData

    }

    override fun getItemCount(): Int {
        return mPostArray.size
    }

}