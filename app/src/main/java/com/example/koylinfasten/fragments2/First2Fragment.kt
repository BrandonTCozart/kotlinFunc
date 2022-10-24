package com.example.koylinfasten.fragments2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.koylinfasten.Objects.RetrofitHelper
import com.example.koylinfasten.R
import com.example.koylinfasten.databinding.FragmentFirst2Binding
import com.example.koylinfasten.interfaces.RetrofitEndPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class First2Fragment : Fragment() {

    private var _binding: FragmentFirst2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirst2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button13.setOnClickListener{

            // RetroFit //
            val quotesApi = RetrofitHelper.getInstance().create(RetrofitEndPoint::class.java)
            // launching a new coroutine
            GlobalScope.launch {
                val result = quotesApi.getQuotes() // results equals a resonse<quotelist>
                if (result != null)
                // Checking the results
                // Log.d("B: ", result.body().toString()) // .body gives the The deserialized response body of a successful response.
                binding.editTextTextPersonName3.setText(result.body().toString())

            }


            // Retrofit //
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}