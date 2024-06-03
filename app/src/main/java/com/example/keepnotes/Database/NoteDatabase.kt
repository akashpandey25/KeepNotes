package com.example.keepnotes.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.keepnotes.model.Note


@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNoteDao(): noteDAO
    //singleton design pattern
    companion object{
        @Volatile
        private var instance:NoteDatabase?=null
        private val LOCK=Any()

        operator fun invoke(context: Context)= instance ?:
        synchronized(this){
            instance?:
            createDatabase(context).also{
                instance=it
            }
        }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                name = "Note_DB"
            ).build()
    }

}