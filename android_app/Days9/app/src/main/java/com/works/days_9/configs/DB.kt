package com.works.days_9.configs

import androidx.room.Database
import androidx.room.RoomDatabase
import com.works.days_9.dao.NoteDao
import com.works.days_9.entities.Note

@Database(entities = [Note::class], version = 1)
abstract class DB : RoomDatabase() {

    abstract fun noteDao() : NoteDao

}