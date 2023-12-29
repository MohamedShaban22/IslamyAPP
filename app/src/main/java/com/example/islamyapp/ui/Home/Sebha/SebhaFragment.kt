package com.example.islamyapp.ui.Home.Sebha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.islamyapp.R
import com.example.islamyapp.databinding.FragmentRadioBinding
import com.example.islamyapp.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var viewBinding:FragmentSebhaBinding
    lateinit var seb7aBody: ImageView
    lateinit var countTextView: TextView
    lateinit var convertTextView: TextView
    var count =0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding=FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seb7aBody=viewBinding.bodySeb7a
        countTextView=viewBinding.countSeb7a
        convertTextView=viewBinding.convertTv

        convertTextView.text=Constant().SOBHANALLH
        countTextView.text="$count"
        seb7aBody.setOnClickListener(){
            onCLickSebha()

        }
    }
    fun onCLickSebha(){
        seb7aBody.rotation= (seb7aBody.rotation+5)
        count++
        countTextView.text="$count"

        if(convertTextView.text==Constant().ELKHATEMA) {

            convertTextView.text = Constant().ELKHATEMA
            count = 0
            countTextView.text = "$count"
        }

        if (count==33) {
            if (convertTextView.text == Constant().SOBHANALLH) {
                convertTextView.text = Constant().ELHAMDLLAH
                count = 0
                countTextView.text="$count"

            } else if (convertTextView.text == Constant().ELHAMDLLAH) {
                convertTextView.text = Constant().ALLAHAKBAR
                count = 0
                countTextView.text="$count"

            } else if (convertTextView.text == Constant().ALLAHAKBAR) {
                convertTextView.text = Constant().ELKHATEMA
                count = 0
                countTextView.text="$count"

            }

        }

    }

}