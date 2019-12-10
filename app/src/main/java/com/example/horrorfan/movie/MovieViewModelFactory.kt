package com.example.horrorfan.movie

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.horrorfan.database.HorrorDao

class MovieViewModelFactory(private val dataSource: HorrorDao, private val application: Application
,private val title: String) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(dataSource, application,title) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}