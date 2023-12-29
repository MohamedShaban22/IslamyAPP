package com.example.islamyapp.ui.Home.Quran

import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R

class SuraDetailsActivity : AppCompatActivity() {
    var suraName:String?=null
    var suraPosition:Int?=null
    lateinit var  suraTitleText:TextView
    lateinit var backIcon:ImageView
    lateinit var recyclerView:RecyclerView
    lateinit var  adapter:VerseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        suraName= intent.getStringExtra("sura_name")
        suraPosition= intent.getIntExtra("sura_position",-1)
        suraTitleText=findViewById(R.id.sura_title_text)
        backIcon=findViewById(R.id.ic_back)
        suraTitleText.text=suraName
        backIcon.setOnClickListener {
            finish()
        }
        recyclerView=findViewById(R.id.sura_details_recycler_view)
        adapter= VerseAdapter(null)
        recyclerView.adapter=adapter
        readVerseFromAssets()
    }

    fun readVerseFromAssets(){
        val fileContent=assets.open("$suraPosition.txt").bufferedReader().use {
            it.readText()}
            var data =fileContent.trim().split("\n")
            adapter.updateData(data)
    }
}