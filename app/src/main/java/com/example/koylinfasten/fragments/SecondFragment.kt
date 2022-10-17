package com.example.koylinfasten.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.koylinfasten.R
import com.example.koylinfasten.classes.Note
import com.example.koylinfasten.databinding.FragmentSecondBinding
import com.example.koylinfasten.adapters.notesAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var notes: ArrayList<Note>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {




        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notes = Note.createNotesList(30)
        val adapter = notesAdapter(notes)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(context)

        binding.button.setOnClickListener{
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        binding.button4.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_NoteNewFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}