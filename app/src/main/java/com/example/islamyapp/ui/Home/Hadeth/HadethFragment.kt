package com.example.islamyapp.ui.Home.Hadeth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R
import com.example.islamyapp.databinding.FragmentHadethBinding
import com.example.islamyapp.databinding.FragmentQuranBinding

class HadethFragment : Fragment() {

    lateinit var viewBinding: FragmentHadethBinding
    lateinit var  recyclerView: RecyclerView
    lateinit var adapter:HadethAdapter
    lateinit var hadethList:MutableList<HadethData>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding =FragmentHadethBinding.inflate(inflater,container,false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.ahadeth_recycler_View)
        adapter=HadethAdapter(null)
        recyclerView.adapter=adapter
        readFileContent()
        adapter.onHadethItemClickListener=object :OnHadethItemClickListener{
            override fun onHadethItemClick(hadeth: HadethData) {
                val intent=Intent(requireActivity(),HadethDetailsActivity::class.java)
                intent.putExtra("hadeth_content",hadeth.hadethContent)
                intent.putExtra("hadeth_tittle",hadeth.hadethTitle)

                startActivity(intent)
            }
        }

    }


    fun readFileContent(){
        hadethList= ArrayList()
        val fileContent=requireActivity().assets.open("ahadeth.txt").bufferedReader().use {
            it.readText()}
        val hadeth=fileContent.trim().split("#")
        hadeth.forEachIndexed{index,hadethContent ->
            val singleHadeth=hadethContent.trim().split("\n")
            val hadethObject=HadethData(index+1,singleHadeth.get(0),hadethContent)
            hadethList.add(hadethObject)

        }
        adapter.updateData(hadethList)
    }
}

