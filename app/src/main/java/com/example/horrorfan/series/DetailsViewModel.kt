package com.example.horrorfan.series

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.horrorfan.database.HorrorDao
import com.example.horrorfan.database.Series
import kotlinx.coroutines.*
import timber.log.Timber

class DetailsViewModel(val database: HorrorDao, application: Application, title:String) : AndroidViewModel(application) {
    init{
        Timber.i("DetailsViewModel constructed")
        getSelectedSeries()
    }

    private var title = title
    private var viewModelJob = Job()
    private var _series = MutableLiveData<Series?>()
    val series
        get() = _series

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        Timber.i("DetailsViewModel cleared")
    }

    private fun getSelectedSeries() {
        CoroutineScope(Job() + Dispatchers.Main).launch {
            series.value = getMovieFromDatabase()
        }
    }

    private suspend fun getMovieFromDatabase():Series?{
        return withContext(Dispatchers.IO){
            var series = database.getSerie(title)
            series
        }
    }
}