package com.example.koylinfasten.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.koylinfasten.R
import com.example.koylinfasten.databinding.FragmentNoteNewBinding
import com.example.koylinfasten.DBdataModel.realmDataModelObject
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import java.util.Calendar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NoteNewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoteNewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentNoteNewBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNoteNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var calendar: Calendar = Calendar.getInstance()

        val config = RealmConfiguration.Builder(schema = setOf(realmDataModelObject::class))
            .build()
        val realm: Realm = Realm.open(config)


        binding.button5.setOnClickListener {
            findNavController().navigate(R.id.action_noteNewFragment_to_SecondFragment)
        }

        binding.button6.setOnClickListener {
            var titleOfNew = binding.editTextTextPersonName2.text.toString()
            var textOfNew = binding.editTextTextMultiLine.text.toString()

            realm.writeBlocking {
                copyToRealm(realmDataModelObject().apply {
                    title = titleOfNew
                    noteText = textOfNew
                    creationDate = calendar.time.toString()
                    creationTime = calendar.time.toString()
                })
            }
            realm.close()

            //findNavController().navigate(R.id.action_noteNewFragment_to_SecondFragment)

            val fragment: Fragment = SecondFragment()

            parentFragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment_content_main, fragment)?.commit()


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