package com.example.islamyapp.ui.Home.Hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamyapp.R

class HadethAdapter(var hadethList:List<HadethData>?=null):Adapter<HadethAdapter.HadethViewHolder>() {

     var onHadethItemClickListener:OnHadethItemClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {

        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeth,parent,false)
        return HadethViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hadethList?.size?:0
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        var item=hadethList?.get(position)
        holder.hadethText.text= item?.hadethTitle
        holder.view.setOnClickListener(){
            onHadethItemClickListener?.onHadethItemClick(item?:return@setOnClickListener)
        }
    }
    fun updateData(hadethList:List<HadethData>){
        this.hadethList=hadethList
        notifyDataSetChanged()
    }

    class HadethViewHolder(val view: View):ViewHolder(view){

        val hadethText:TextView=view.findViewById(R.id.hadeth_text)
    }



}