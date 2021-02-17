package com.example.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Notes(
    @ColumnInfo(name = "text") val text: String,

) {
    @PrimaryKey(autoGenerate = true) val id=0
}