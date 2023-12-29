package com.example.islamyapp.ui.Home.Radio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamyapp.R
import com.example.islamyapp.databinding.FragmentHadethBinding
import com.example.islamyapp.databinding.FragmentQuranBinding
import com.example.islamyapp.databinding.FragmentRadioBinding

lateinit var viewBinding: FragmentRadioBinding

class RadioFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentRadioBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

}