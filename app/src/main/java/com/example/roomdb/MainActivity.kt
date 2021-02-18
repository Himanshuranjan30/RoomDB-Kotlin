package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel: notesviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rv=findViewById<RecyclerView>(R.id.rv_todo)
        rv.layoutManager=LinearLayoutManager(this)
        val adapter=rvadapter(this,this)
        rv.adapter=adapter
        viewmodel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(notesviewmodel::class.java)
        viewmodel.allnotes.observe(this, Observer {
            adapter.updatelist(it)
        })


    }
    fun onItemClicked(note: Notes) {
        viewmodel.deletenode(note)
        Toast.makeText(this,"inserted",Toast.LENGTH_SHORT).show()
    }
    fun submitdata(view: View){
        val et=findViewById<EditText>(R.id.et_add)
        val notetext=et.text.toString()
        if(notetext.isNotEmpty()){
            viewmodel.insertnote(Notes(notetext))
        }
    }
}