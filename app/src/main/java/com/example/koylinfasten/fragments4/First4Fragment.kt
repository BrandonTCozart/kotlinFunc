package com.example.koylinfasten.fragments4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.koylinfasten.R
//import com.example.koylinfasten.activities.databinding.FragmentFirst4Binding
import com.example.koylinfasten.databinding.FragmentFirst4Binding
import com.example.koylinfasten.fragments.NoteNewFragment

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class First4Fragment : Fragment() {

    private var _binding: FragmentFirst4Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirst4Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button18.setOnClickListener{
            findNavController().navigate(R.id.action_First4Fragment_to_fragment4Fragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}