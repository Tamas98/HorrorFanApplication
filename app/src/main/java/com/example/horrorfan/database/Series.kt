package com.example.horrorfan.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Series")
data class Series(

    @NonNull
    @PrimaryKey
    var seriesId:Long = 0L,

    @NonNull
    @ColumnInfo(name = "title")
    var title:String = "",

    @NonNull
    @ColumnInfo(name="seasons")
    var seasons: Int,

    @NonNull
    @ColumnInfo(name="on_air_date")
    var on_air_date:String = "",

    @NonNull
    @ColumnInfo(name="genres")
    var genres:String ="",

    @NonNull
    @ColumnInfo(name = "description")
    var description:String=""
)