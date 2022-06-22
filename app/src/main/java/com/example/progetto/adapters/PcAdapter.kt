package com.example.progetto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progetto.Pc
import com.example.progetto.R

class PcAdapter(private val pcList:ArrayList<Pc>)
    : RecyclerView.Adapter<PcAdapter.PcViewHolder>(){

    var onItemClick : ((Pc) -> Unit)? = null

    class PcViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textItem : TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PcViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pc_list, parent, false )
        return PcViewHolder(view)
    }

    override fun onBindViewHolder(holder: PcViewHolder, position: Int) {
        val pc = pcList[position]
        holder.imageView.setImageResource(pc.image)
        holder.textItem.text = pc.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(pc)

        }
    }

    override fun getItemCount(): Int {
        return pcList.size
    }
}