package com.example.roomdb

import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note:Notes)
    @Delete
    fun delete(note:Notes)
    @Query("Select * from notes_table order by id ASC")
    fun getallnotes():List<Notes>
}