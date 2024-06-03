package com.example.keepnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.keepnotes.adapter.NoteAdapter
import com.example.keepnotes.databinding.FragmentHomeBinding
import com.example.keepnotes.databinding.FragmentNewNoteBinding
import com.example.keepnotes.model.Note
import com.example.keepnotes.noteviewmodel.NoteViewModel


class NewNoteFragment : Fragment() {
    private var _binding: FragmentNewNoteBinding?=null
    private val binding get()=_binding!!

    private lateinit var notesViewModel: NoteViewModel
    private lateinit var notesAdapter: NoteAdapter
    private lateinit var mView:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentNewNoteBinding.inflate(inflater, container, false)
        return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = (activity as MainActivity).noteViewModel
        mView = view
    }

    private  fun saveNote(view: View){
        val noteTitle=binding.etNoteTitle.text.toString()
        val noteBody=binding.etNoteBody.text.toString().trim()

        if(noteTitle.isNotEmpty()){
            val note= Note(0, noteTitle, noteBody )

            notesViewModel.addNote(note)

            Toast.makeText(mView.context,
                "Note Saved Successfully",
                Toast.LENGTH_LONG
            ).show()

            view.findNavController().navigate(R.id.action_newNoteFragment_to_homeFragment)
        }
        else{
            Toast.makeText(
                mView.context,
                "Please! Enter The Note Title",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_new_note, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_save ->{
                saveNote(mView)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}