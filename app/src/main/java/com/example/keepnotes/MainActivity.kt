package com.example.keepnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.keepnotes.Database.NoteDatabase
import com.example.keepnotes.databinding.ActivityMainBinding
import com.example.keepnotes.noteviewmodel.NoteViewModel
import com.example.keepnotes.noteviewmodel.ViewModelFactory
import com.example.keepnotes.repository.NoteRepository

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository=NoteRepository(NoteDatabase(this))

        val viewModelProvideFactory=ViewModelFactory(application, noteRepository)

        noteViewModel=ViewModelProvider(
            this,
            viewModelProvideFactory
        ).get(NoteViewModel::class.java)
    }
}