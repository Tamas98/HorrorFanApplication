package com.example.horrorfan.movie

import androidx.lifecycle.ViewModel
import timber.log.Timber

class MovieViewModel : ViewModel() {
    init{
        Timber.i("MovieViewModel constructed")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("MovieViewModel cleared")
    }
}