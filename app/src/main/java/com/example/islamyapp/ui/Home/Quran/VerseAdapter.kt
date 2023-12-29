package com.example.islamyapp.ui.Home.Quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamyapp.R

class VerseAdapter(var verseList:List<String>?) :Adapter<VerseAdapter.VerseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
       val view:View=LayoutInflater.from(parent.context)
           .inflate(R.layout.item_verse,parent,false )
        return VerseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return verseList?.size ?: 0
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        val item=verseList?.get(position)
        holder.verseTextView.text=item

    }

    class VerseViewHolder(val view: View) :ViewHolder(view){
        val verseTextView:TextView=view.findViewById(R.id.verse_tv)

    }
    fun updateData(verseList: List<String>?){
        this.verseList =  verseList
        notifyDataSetChanged()
    }


}