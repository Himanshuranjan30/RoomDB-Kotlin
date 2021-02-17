package com.example.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Notes::class), version = 1, exportSchema = false)
abstract class NotesDB : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NotesDB? = null

        fun getDatabase(context: Context): NotesDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDB::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}