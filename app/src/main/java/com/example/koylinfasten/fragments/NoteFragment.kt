package com.example.koylinfasten.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.koylinfasten.R
import com.example.koylinfasten.classes.Note
import com.example.koylinfasten.databinding.FragmentSecondBinding
import com.example.koylinfasten.adapters.notesAdapter
import com.example.koylinfasten.ViewModels.NoteModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NoteFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    lateinit var notes: ArrayList<Note>
    lateinit var adapter: notesAdapter
    private val viewModel: NoteModel by activityViewModels()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notes = viewModel.updateListOfNotes()

        adapter = notesAdapter(notes)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(context)



        binding.button.setOnClickListener{

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.button4.setOnClickListener {

            val fragment: Fragment = NoteNewFragment()
            parentFragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment_content_main, fragment)?.commit()
        }

        // OnClickListeners //
        adapter.setOnItemClickListener(object : notesAdapter.onItemClickListener{

            override fun onItemClick(position: Int) {

                setFragmentResult("requestKey", bundleOf("bundleKey" to position))

                val fragment: Fragment = NoteNewFragment()
                parentFragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment_content_main, fragment)?.commit()

            }


            override fun onDeleteButtonClick(position: Int) {

                viewModel.deleteNote(position)

                val fragment: Fragment = NoteFragment()
                parentFragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment_content_main, fragment)?.commit()

            }

        })
        // OnClickListeners //
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}