package com.example.koylinfasten.fragments3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.koylinfasten.R
import com.example.koylinfasten.ViewModels.SignatureViewModel
import com.example.koylinfasten.databinding.FragmentFirst3Binding
import com.example.koylinfasten.databinding.FragmentSecondBinding

class First3Fragment : Fragment() {

    private var _binding: FragmentFirst3Binding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = First3Fragment()
    }

    private lateinit var viewModel: SignatureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignatureViewModel::class.java)
        // TODO: Use the ViewModel

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirst3Binding.inflate(inflater, container, false)
        return binding.root
    }

}