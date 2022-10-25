package com.example.koylinfasten.fragments2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.koylinfasten.ViewModels.QuoteModel
import com.example.koylinfasten.databinding.FragmentFirst2Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class First2Fragment : Fragment() {

    private var _binding: FragmentFirst2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var index : Int = 0
    private val quoteModel: QuoteModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirst2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button13.setOnClickListener{

            binding.textView.setText(quoteModel.quoteGet())
            binding.editTextTextPersonName3.setText(quoteModel.authorGet())

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}