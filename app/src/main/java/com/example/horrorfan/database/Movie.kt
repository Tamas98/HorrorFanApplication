package com.example.horrorfan.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movies")
data class Movies (

    @PrimaryKey(autoGenerate = true)
    var movieId:Long = 0L,

    @ColumnInfo(name = "title")
    var title:String = "",

    @ColumnInfo(name="release_date")
    var release_date:String = "",

    @ColumnInfo(name="genres")
    var genres:String ="",

    @ColumnInfo(name = "description")
    var description:String=""
)