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
        getSelectedMovie(title)
    }

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var movie = MutableLiveData<Movies?>()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        Timber.i("MovieViewModel cleared")
    }

    fun getSelectedMovie(title:String){
        uiScope.launch {
            movie.value = getMovieFromDatabase(title)
        }
    }

    private suspend fun getMovieFromDatabase(title:String):Movies{
        return withContext(Dispatchers.IO){
            var movie = database.getMovie(title)
            movie
        }
    }
}