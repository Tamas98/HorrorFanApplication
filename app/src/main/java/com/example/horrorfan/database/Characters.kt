package com.example.horrorfan.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Characters")
data class Characters (

    @PrimaryKey(autoGenerate = true)
    var characterId:Long = 0L,

    @ColumnInfo(name="name")
    var name:String = "",

    @ColumnInfo(name="first_apparence")
    var first_apparance:String="",

    @ColumnInfo(name="movies")
    var movies:String = "",

    @ColumnInfo(name="extras")
    var extras:String = ""
)