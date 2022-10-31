package com.example.koylinfasten.fragments4

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.koylinfasten.R
import com.example.koylinfasten.ViewModels.PostModel
//import com.example.koylinfasten.activities.databinding.FragmentFirst4Binding
import com.example.koylinfasten.databinding.FragmentFirst4Binding
import com.example.koylinfasten.fragments.NoteNewFragment
import com.example.koylinfasten.interfaces.IActivityTransaction

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class First4Fragment : Fragment() {

    private var _binding: FragmentFirst4Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val postModel: PostModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirst4Binding.inflate(inflater, container, false)

        binding.calendarView.visibility = View.INVISIBLE

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button17.setOnClickListener {
            Ilistener.toFirstActivity()
        }

        binding.button18.setOnClickListener{
            findNavController().navigate(R.id.action_First4Fragment_to_fragment4Fragment)
        }

        binding.button19.setOnClickListener {
            var title = binding.editTextTextPersonName5.text.toString()
            var content = binding.editTextTextPersonName6.text.toString()

            if(title.isNotEmpty() && content.isNotEmpty()){
                //postModel.addPosts(title, content)
                postModel.sendPostInfo(title, content)
                binding.editTextTextPersonName5.setText("")
                binding.editTextTextPersonName6.setText("")
                var cm: ConnectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

                if(cm.activeNetwork != null){
                    Toast.makeText(context, "Posted", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Will post when online", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(context, "Fields Empty", Toast.LENGTH_SHORT).show()
            }
        }



        binding.button20.setOnClickListener {
            binding.calendarView.visibility = View.VISIBLE
            binding.button20.visibility = View.INVISIBLE
            binding.textView3.visibility = View.INVISIBLE
        }

        binding.calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->

            var dtStr = "$i2/$i3/$i"
            Toast.makeText(context, dtStr, Toast.LENGTH_SHORT).show()
            binding.button20.visibility = View.VISIBLE
            binding.textView3.visibility = View.VISIBLE
            binding.calendarView.visibility =View.INVISIBLE
            binding.textView3.setText(dtStr)

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