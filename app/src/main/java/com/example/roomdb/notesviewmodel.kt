package com.example.roomdb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class notesviewmodel(application: Application):AndroidViewModel(application) {


    val allnotes:LiveData<List<Notes>>
    val repository:NoteRepo


    init {
        val dao=NotesDB.getDatabase(application).getNoteDao()
        repository=NoteRepo(dao)
        allnotes=repository.getallnotes

    }
    fun deletenode(note:Notes)=viewModelScope.launch(Dispatchers.IO) {
repository.delete(note)
    }

    fun insertnote(note: Notes)=viewModelScope.launch (Dispatchers.IO
    ){
        repository.insert(note)
    }
    }
