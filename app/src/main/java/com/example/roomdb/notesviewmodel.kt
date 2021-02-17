package com.example.roomdb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class notesviewmodel(application: Application):AndroidViewModel(application) {


    val allnotes:LiveData<List<Notes>>

    init {
        val dao=NotesDB.getDatabase(application).getNoteDao()
        val repository=NoteRepo(dao)
        allnotes=repository.getallnotes

    }
}