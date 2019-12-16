package com.example.horrorfan.database

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Movies")
data class Movies (

    @NonNull
    @PrimaryKey
    var movieId:Long = 0L,

    @NonNull
    @ColumnInfo(name = "title")
    var title:String = "",

    @NonNull
    @ColumnInfo(name="release_date")
    var release_date:String = "",

    @NonNull
    @ColumnInfo(name="genres")
    var genres:String ="",

    @NonNull
    @ColumnInfo(name = "description")
    var description:String=""
)
