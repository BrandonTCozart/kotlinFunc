package com.example.koylinfasten.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.koylinfasten.R
import com.example.koylinfasten.databinding.FragmentFirstBinding
import com.example.koylinfasten.interfaces.IActivityTransaction

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToNotes.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonNextActivity.setOnClickListener {
            Ilistener.toNextActivity() //Main Activity .toNextActivity
        }

        binding.button16.setOnClickListener{
            Ilistener.toPostActivity()
        }
        binding.button24.setOnClickListener {
            Ilistener.toThreadActivity()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    lateinit var Ilistener: IActivityTransaction

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is IActivityTransaction){
            Ilistener = context // Ilistener is equal to the context which is the main activity
        }else{
            throw java.lang.RuntimeException("must apply context")
        }
    }



}