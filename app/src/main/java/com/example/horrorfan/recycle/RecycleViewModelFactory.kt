package com.example.horrorfan.recycle

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.horrorfan.database.HorrorDao

class RecycleViewModelFactory(private val dataSource: HorrorDao, private var application: Application):
    ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecycleViewModel::class.java)) {
            return RecycleViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}