package com.works.days_9.dao

import androidx.room.*
import com.works.days_9.entities.Note

@Dao
interface NoteDao{

    @Insert
    fun insert(note: Note) : Long

    @Delete
    fun delete(note: Note) : Int

    @Update
    fun update(note: Note) : Int

    @Query("select * from note where nid = :nid")
    fun findById(nid: Int) : Note?

    @Query("select * from note")
    fun findAll() : List<Note>

    @Query("select * from note where title like :title")
    fun findSearchTitle( title: String ) : List<Note>

}