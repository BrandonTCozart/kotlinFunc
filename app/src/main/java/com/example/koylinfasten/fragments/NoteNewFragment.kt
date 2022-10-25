package com.example.koylinfasten.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import com.example.koylinfasten.R
import com.example.koylinfasten.databinding.FragmentNoteNewBinding
import com.example.koylinfasten.ViewModels.NoteModel
import com.example.koylinfasten.classes.Note
import io.realm.kotlin.Realm

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NoteNewFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentNoteNewBinding? = null
    private val binding get() = _binding!!


    lateinit var notes: ArrayList<Note>
    lateinit var realm: Realm

    private val viewModel: NoteModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


        setFragmentResultListener("requestKey"){ requestKey, bundle ->
            var position = bundle.getInt("bundleKey")

            notes = viewModel.updateListOfNotes()

            binding.editTextTextPersonName2.setText(notes[position].title)
            binding.editTextTextMultiLine.setText(notes[position].noteText)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNoteNewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button5.setOnClickListener {
            val fragment: Fragment = NoteFragment()
            parentFragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment_content_main, fragment)?.commit()
        }


        binding.button6.setOnClickListener {
            var titleOfNew = binding.editTextTextPersonName2.text.toString()
            var textOfNew = binding.editTextTextMultiLine.text.toString()

            if(viewModel.validateNotEmpty(titleOfNew, textOfNew)){

                viewModel.writeNewNoteToDatabase(titleOfNew, textOfNew)
                val fragment: Fragment = NoteFragment()
                parentFragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment_content_main, fragment)?.commit()

            }else{
                Toast.makeText(context, "Fields must not be empty", Toast.LENGTH_SHORT).show()

            }

        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NoteNewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NoteNewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}