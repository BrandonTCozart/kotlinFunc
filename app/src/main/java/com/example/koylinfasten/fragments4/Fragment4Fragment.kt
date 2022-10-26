package com.example.koylinfasten.fragments4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.koylinfasten.R
import com.example.koylinfasten.ViewModels.NoteModel
import com.example.koylinfasten.ViewModels.PostModel
import com.example.koylinfasten.adapters.PostAdapter
import com.example.koylinfasten.classes.Post
import com.example.koylinfasten.databinding.FragmentFragment4Binding
import com.example.koylinfasten.databinding.FragmentNoteNewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment4Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment4Fragment : Fragment() {
    private var _binding: FragmentFragment4Binding? = null
    private val binding get() = _binding!!
    lateinit var posts: ArrayList<Post>
    private val postModel: PostModel by activityViewModels()



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFragment4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        posts = postModel.getPosts()
        val adapter = PostAdapter(posts)
        binding.postRecycler.adapter = adapter
        binding.postRecycler.layoutManager = LinearLayoutManager(context)

    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment4Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment4Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}