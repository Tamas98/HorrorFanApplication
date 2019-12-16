package com.example.horrorfan.recycle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.horrorfan.database.HorrorDao
import com.example.horrorfan.database.Movies

class RecycleViewModel(val database: HorrorDao, application: Application) : AndroidViewModel(application) {
    var movies: LiveData<List<Movies>> = database.getAllMovie()
}