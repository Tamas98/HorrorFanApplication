package com.example.horrorfan.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Series")
data class Series(

    @PrimaryKey(autoGenerate = true)
    var seriesId:Long = 0L,

    @ColumnInfo(name = "title")
    var title:String = "",

    @ColumnInfo(name="seasons")
    var seasons: Int,

    @ColumnInfo(name="on_air_date")
    var on_air_date:String = "",

    @ColumnInfo(name="genres")
    var genres:String ="",

    @ColumnInfo(name = "description")
    var description:String=""
)