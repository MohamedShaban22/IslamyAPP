package com.example.islamyapp.ui.Home.Hadeth

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R
import com.example.islamyapp.ui.Home.Quran.VerseAdapter

class HadethDetailsActivity: AppCompatActivity() {
     var hadethName:String?=null
    lateinit var hadethTitle:TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:VerseAdapter
    lateinit var backIcon: ImageView
     var hadethContent:String?=null
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
                initViews()
    }

    private fun initViews(){
        hadethContent=intent.getStringExtra("hadeth_content")
        hadethName=intent.getStringExtra("hadeth_tittle")
        recyclerView=findViewById(R.id.hadeth_details_recycler_view)
        hadethTitle= findViewById(R.id.hadeth_title_text)
        hadethTitle.text=hadethName
        adapter=VerseAdapter(null)
        adapter.updateData(hadethContent?.split("\n"))
        recyclerView.adapter=adapter
        backIcon=findViewById(R.id.ic_back)

        backIcon.setOnClickListener{
            finish()
        }

    }
}