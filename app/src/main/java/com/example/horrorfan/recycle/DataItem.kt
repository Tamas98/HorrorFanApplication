package com.example.horrorfan.recycle

import com.example.horrorfan.database.Movies

sealed class DataItem {
    abstract val id: Long

    data class MovieItem(val movie: Movies): DataItem(){
        override val id = movie.movieId
    }

    object Header: DataItem(){
        override val id = Long.MIN_VALUE
    }
}