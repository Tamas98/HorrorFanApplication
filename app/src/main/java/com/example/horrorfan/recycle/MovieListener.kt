package com.example.horrorfan.recycle

import com.example.horrorfan.database.Movies

class MovieListener(val clickListener: (movieId: Long) -> Unit) {
    fun onClick(movie: Movies) = clickListener(movie.movieId)
}