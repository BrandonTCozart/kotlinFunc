package com.example.koylinfasten.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.koylinfasten.R
import com.example.koylinfasten.classes.Note
import com.example.koylinfasten.databinding.FragmentSecondBinding
import com.example.koylinfasten.adapters.notesAdapter
import com.example.koylinfasten.DBdataModel.realmDataModelObject
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var notes: ArrayList<Note>
    lateinit var realm: Realm
    lateinit var adapter: notesAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val config = RealmConfiguration.Builder(schema = setOf(realmDataModelObject::class))
            .build()

        realm = Realm.open(config)

        updateRecyclerView()
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

                realm.writeBlocking {
                    val writeTransactionItems = query<realmDataModelObject>().find()
                    delete(writeTransactionItems[position])
                }
                val fragment: Fragment = SecondFragment()
                parentFragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment_content_main, fragment)?.commit()

            }

        })
        // OnClickListeners //
    }




    // Function to return array of notes from db //
    fun updateRecyclerView() {
        var items: RealmResults<realmDataModelObject> = realm.query<realmDataModelObject>().find()
        var notez: ArrayList<Note> = ArrayList()
        for(position in items){
            notez.add(Note(position.title, position.noteText, position.note_Id,position.creationTime))
        }
        notes = notez
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}