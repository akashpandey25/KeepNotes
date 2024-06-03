package com.example.keepnotes.repository

import androidx.room.Query
import com.example.keepnotes.Database.NoteDatabase
import com.example.keepnotes.model.Note

class NoteRepository(private val db:NoteDatabase) {

    suspend fun insertNote(note:Note)=db.getNoteDao().insertNote(note)
    suspend fun updateNote(note: Note)=db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note)=db.getNoteDao().deleteNote(note)

    fun getAllNote()=db.getNoteDao().getAllNotes()
    fun searchNotes(query: String?)=db.getNoteDao().serachNote(query)


}