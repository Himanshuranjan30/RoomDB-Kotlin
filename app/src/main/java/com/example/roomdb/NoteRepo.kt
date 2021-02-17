package com.example.roomdb

import androidx.lifecycle.LiveData

class NoteRepo(private val noteDao: NoteDao) {

    val getallnotes: LiveData<List<Notes>> = noteDao.getallnotes()
    suspend fun insert(note: Notes) {
        noteDao.insert(note)
    }

    suspend fun delete(note: Notes) {
        noteDao.delete(note)
    }
}