package com.example.horrorfan.database

import androidx.room.Dao
import androidx.room.Query
import com.example.horrorfan.database.Characters
import com.example.horrorfan.database.Movies
import com.example.horrorfan.database.Series

@Dao
interface HorrorDao {
    @Query("Select * from Movies where title = :title")
    fun getMovie(title: String): Movies

    @Query("Select * from Series where title = :title")
    fun getSerie(title: String): Series

    @Query("Select * from Characters where name = :name")
    fun getCharacter(name: String): Characters
}