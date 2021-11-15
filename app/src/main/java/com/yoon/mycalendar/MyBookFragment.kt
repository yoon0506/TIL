package com.yoon.mycalendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.yoon.mycalendar.databinding.ActivityMainBinding
import com.yoon.mycalendar.databinding.FragmentMyBookBinding


class MyBookFragment : Fragment() {

    private lateinit var binding : FragmentMyBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentMyBookBinding.inflate(layoutInflater)

        setFragmentResultListener("requestKey"){ _, bundle ->
            val result = bundle.getString("bundleKey")
            Toast.makeText(context, "결과 : $result",Toast.LENGTH_SHORT).show()
            binding.resultText.text = result
        }
    }
    override fun onCreateView(
        inflater:                                                                                                                                                                                                                                                                                                                                                                                    LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_book, container, false)

//        binding.nextButton.setOnClickListener { view : View ->
//            view.findNavController().navigate(R.id.action_fragEbook_to_fragEbookDetail)
//            oast.makeText(context, "클릭",Toast.LENGTH_SHORT).show()
//        }
        binding.resultText.text = "바보"
        binding.nextButton.setOnClickListener { OnClickListener { binding.resultText.text = "메롱" } }
    }

}