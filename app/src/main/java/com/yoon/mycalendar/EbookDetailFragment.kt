package com.yoon.mycalendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import com.yoon.mycalendar.databinding.FragmentEbookDetailBinding
import com.yoon.mycalendar.databinding.FragmentMyBookBinding

class EbookDetailFragment : Fragment() {

    private lateinit var binding : FragmentEbookDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentEbookDetailBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ebook_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {view : View->
            val result = binding.editText.text
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            view.findNavController().navigate(R.id.action_fragEbookDetail_to_fragMyBook)
        }
    }
}