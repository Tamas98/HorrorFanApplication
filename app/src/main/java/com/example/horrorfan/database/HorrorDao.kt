package com.example.horrorfan.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.horrorfan.database.Characters
import com.example.horrorfan.database.Movies
import com.example.horrorfan.database.Series

@Dao
interface HorrorDao {

    @Query("Select * from Movies where title = :title")
    fun getMovie(title:String): Movies

   @Query("Select * from Movies")
   fun getAllMovie() : LiveData<List<Movies>>

    @Query("Select * from Movies where movieId = :id")
    fun getMovieById(id: Long) : Movies


    @Query("Select * from Series where title = :title")
    fun getSerie(title: String): Series

    @Query("Select * from Series")
    fun getAllSeries(): LiveData<List<Series>>

    @Query("Select * from Characters where name = :name")
    fun getCharacter(name: String): Characters

    @Query("Select * from Characters")
    fun getAllCharacter() : LiveData<List<Characters>>
}