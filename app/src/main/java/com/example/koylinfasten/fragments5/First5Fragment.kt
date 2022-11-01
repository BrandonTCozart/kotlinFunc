package com.example.koylinfasten.fragments5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.koylinfasten.R
//import com.example.koylinfasten.activities.databinding.FragmentFirst5Binding
import com.example.koylinfasten.databinding.FragmentFirst5Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class First5Fragment : Fragment() {

    private var _binding: FragmentFirst5Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirst5Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var truth: Boolean = false
        var progress: Int = 0
        var progress2: Int = 0
        var progress3: Int = 0
        var progress4: Int = 0


        binding.button25.setOnClickListener {

            Thread(Runnable {

                    for(i in 1..100){
                        if(i == 99){
                            truth = true

                        }
                        progress++
                        binding.progressBar.progress = progress
                        Thread.sleep(100L)
                    }


            }).start()

            Thread(Runnable {


                for(i in 1..100){
                        if(i == 99){
                            truth = true
                        }
                        progress2++
                        binding.progressBar3.progress = progress2
                        Thread.sleep(50L)
                    }


            }).start()

            Thread(Runnable {


                for(i in 1..100){
                        if(i == 99){
                            truth = true
                        }
                        progress3++
                        binding.progressBar4.progress = progress3
                        Thread.sleep(300L)
                    }


            }).start()

            Thread(Runnable {


                for(i in 1..100){
                        if(i == 99){
                            truth = true
                        }
                        progress4++
                        binding.progressBar5.progress = progress4
                        Thread.sleep(250L)
                    }


            }).start()


        }

        fun background() = runBlocking {
            runBlocking {
                launch {
                    for(i in 1..100){
                        if(i == 99){
                            truth = true

                        }
                        progress++
                        binding.progressBar.progress = progress
                        Thread.sleep(100L)
                    }
                }

                launch {
                    for(i in 1..100){
                        if(i == 99){
                            truth = true
                        }
                        progress2++
                        binding.progressBar3.progress = progress2
                        Thread.sleep(50L)
                    }
                }

                launch {
                    for(i in 1..100){
                        if(i == 99){
                            truth = true
                        }
                        progress3++
                        binding.progressBar4.progress = progress3
                        Thread.sleep(300L)
                    }
                }

                launch {
                    for(i in 1..100){
                        if(i == 99){
                            truth = true
                        }
                        progress4++
                        binding.progressBar5.progress = progress4
                        Thread.sleep(250L)
                    }
                }
            }
        }

        binding.button26.setOnClickListener {
            /*binding.progressBar.progress = 0
            binding.progressBar3.progress = 0
            binding.progressBar4.progress = 0
            binding.progressBar5.progress = 0

             */

            background()

        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}