package com.example.horrorfan.movie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.horrorfan.database.HorrorDao
import com.example.horrorfan.database.Movies
import kotlinx.coroutines.*
import timber.log.Timber

class MovieViewModel(val database: HorrorDao,application: Application,title:String) : AndroidViewModel(application) {
    init{
        Timber.i("MovieViewModel constructed")
        getSelectedMovie()
    }

    private var title = title
    private var viewModelJob = Job()
    private var _movie = MutableLiveData<Movies?>()
    val movie
        get() = _movie

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        Timber.i("MovieViewModel cleared")
    }

    private fun getSelectedMovie() {
        CoroutineScope(Job() + Dispatchers.Main).launch {
            movie.value = getMovieFromDatabase()
        }
    }

    private suspend fun getMovieFromDatabase():Movies?{
       return withContext(Dispatchers.IO){
            var movie = database.getMovie(title)
            movie
        }
    }
}