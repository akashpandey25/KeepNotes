package com.example.keepnotes.noteviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.keepnotes.model.Note
import com.example.keepnotes.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    app:Application, private val noteRepository: NoteRepository
):AndroidViewModel(app)
{
    //these are suspend functions so they need coroutines
    fun addNote(note: Note)=
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }

    fun deleteNote(note: Note)=
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }

    fun updateNote(note: Note)=
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    //these are normal function the dont need
    fun getAllNotes()=noteRepository.getAllNote()
    fun searchNotes(query:String?)=
        noteRepository.searchNotes(query)

}