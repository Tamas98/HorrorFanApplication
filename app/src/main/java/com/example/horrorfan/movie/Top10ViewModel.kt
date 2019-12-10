package com.example.horrorfan.movie

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.horrorfan.database.HorrorDao
import com.example.horrorfan.database.Movies
import kotlinx.coroutines.*
import timber.log.Timber

class Top10ViewModel:ViewModel(){//(val database: HorrorDao, application: Application) : AndroidViewModel(application) {
    init{
        Timber.i("Top10ViewModel Created")
        //getAllMovie()
    }

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var movie = MutableLiveData<Array<Movies>?>()

    private val best_of_2019: Array<String> = arrayOf("Pet Semetary","IT:Chapter 2",
        "Countdown",
        "Brightburn",
        "The Perfection",
        "Child\'s Play",
        "The Curse of La Llorona",
        "Us",
        "Ready or Not",
        "The Prodigy")

    /*private fun getAllMovie(){
        uiScope.launch{
            movie.value = queryMovies()
        }
    }

    private suspend fun queryMovies():Array<Movies>{
        return withContext(Dispatchers.IO){
            database.getAllMovies()
        }*/

    //}
}