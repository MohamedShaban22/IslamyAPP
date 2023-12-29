package com.example.islamyapp.ui.Home.Quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamyapp.R

class SuraQuranAdapter(val suraNameList:List<SuraName>) :
    Adapter<SuraQuranAdapter.SuraQuranViewHolder>() {

    var onSuraItemClickListener:OnSuraItemClickListener?=null

    class SuraQuranViewHolder(val view: View):ViewHolder(view){

        val suraName:TextView=view.findViewById(R.id.sura_name_tv)
        val suraPosition:TextView=view.findViewById(R.id.sura_position)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraQuranViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_quran_layout,parent,false)
        return SuraQuranViewHolder(view)
    }

    override fun getItemCount(): Int {
        return suraNameList.size
    }

    override fun onBindViewHolder(holder: SuraQuranViewHolder, position: Int) {
        val item=suraNameList.get(position)
        holder.suraName.text=item.name
        holder.suraPosition.text="${item.suraPosition}"
        holder.view.setOnClickListener(){
            onSuraItemClickListener?.onSuraClick(item)
        }
    }
}
