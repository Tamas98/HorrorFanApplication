package com.example.horrorfan.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Characters")
data class Characters (

    @NonNull
    @PrimaryKey
    var characterId:Long = 0L,

    @NonNull
    @ColumnInfo(name="name")
    var name:String = "",

    @NonNull
    @ColumnInfo(name="first_appearance")
    var first_appearance:String="",

    @NonNull
    @ColumnInfo(name="movies")
    var movies:String = "",

    @NonNull
    @ColumnInfo(name="extras")
    var extras:String = ""
)