package com.example.roomdb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rvadapter(val context: Context, private val listener: MainActivity):RecyclerView.Adapter<rvadapter.NoteViewHolder>() {
   val allnotes=ArrayList<Notes>()
    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView=itemView.findViewById<TextView>(R.id.tv_todo)
        val deletebutton=itemView.findViewById<Button>(R.id.btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
     var viewholder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item,parent,false))
        viewholder.deletebutton.setOnClickListener{
            listener.onItemClicked(allnotes[viewholder.adapterPosition])
        }
        return viewholder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
     val currentnote=allnotes[position]
        holder.textView.text=currentnote.text

    }

    override fun getItemCount(): Int {
        return allnotes.size
    }

    fun updatelist(newlist:List<Notes>){
        allnotes.clear()
        allnotes.addAll(newlist)
        notifyDataSetChanged()
    }
}

interface  InotesRVadapter{
    fun onItemClicked(note:Notes)
}