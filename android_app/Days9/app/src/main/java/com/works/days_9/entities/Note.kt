package com.works.days_9.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "nid")
    val nid:Int?,

    val title: String,
    val detail: String,
    var status: Int
)
