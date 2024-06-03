package com.example.keepnotes.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Index
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.keepnotes.model.Note


@Dao
interface noteDAO {

    @Insert
    suspend fun insertNote(note:Note)

    @Update
    suspend fun updateNote(note:Note)

    @Delete
    suspend fun deleteNote(note:Note)

    @Query("SELECT * FROM NOTES ORDER BY id DESC")
     fun getAllNotes():LiveData<List<Note>>

    @Query("SELECT * FROM NOTES WHERE noteTitle LIKE:query OR noteBody LIKE:query")
    fun serachNote(query:String?):LiveData<List<Note>>
}